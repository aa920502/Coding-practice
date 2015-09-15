// There are a total of n courses you have to take, labeled from 0 to n - 1.

// Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

// Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

// For example:

// 2, [[1,0]]
// There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

// 2, [[1,0],[0,1]]
// There are a total of 2 courses to take. To take course 1 you should have finished course 0, 
// and to take course 0 you should also have finished course 1. So it is impossible.

// Note:
// The input prerequisites is a graph represented by a list of edges, not adjacency matrices. 

class CourseSchedule{
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return false;
        if (prerequisites.length == 0 || prerequisites[0].length == 0) return true;

        //record number of prerequisites for each course
        int[] course = new int[numCourses];

        // <course X, courses that can be taken after X>
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < prerequisites.length; i++) {
            int key = prerequisites[i][1];
            int val = prerequisites[i][0];
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<Integer>());
            }
            map.get(key).add(val);
            course[val]++;
        }

        //Queue contains all free_to_take courses
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (course[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (map.get(cur) != null) {
                for (int temp : map.get(cur)) {
                    course[temp]--;
                    if (course[temp] == 0) { // course becomes available
                        queue.offer(temp);
                    }
                }
            }
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (course[i] != 0) return false;
        }
        return true;
    }
}