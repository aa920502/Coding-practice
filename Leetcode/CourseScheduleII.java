// There are a total of n courses you have to take, labeled from 0 to n - 1.

// Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
// which is expressed as a pair: [0,1]

// Given the total number of courses and a list of prerequisite pairs, 
// return the ordering of courses you should take to finish all courses.

// There may be multiple correct orders, you just need to return one of them. 
// If it is impossible to finish all courses, return an empty array.

// For example:

// 2, [[1,0]]
// There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

// 4, [[1,0],[2,0],[3,1],[3,2]]
// There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

// Note:
// The input prerequisites is a graph represented by a list of edges, not adjacency matrices.

class CourseScheduleII{
    
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return new int[0];

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

        int[] res = new int[numCourses];
        int count = 0;
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
            res[count++] = cur;
        }
        
        return count==numCourses?res:new int[0];
    }
}