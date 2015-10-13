// you have serveral tasks. k is the interval time between two same task. 
// you should keep the order of the tasks
// how much time you should spend to complete all the tasks:
// ABACD, 3 -> 7 because AB__ACD


import java.util.*;
public class TaskArrangeMentI {
	//use a hashtable to record the lastime of the each task
	public static int getTime(String task, int k) {
		if (task == null || task.length() == 0) return 0;
		
		if (k == 0) return task.length();
		
		Map<Character, Integer> lastTime = new HashMap<Character, Integer>();
		int count = 0;
		for (int i = 0; i < task.length(); i++) {
			count++;
			if (lastTime.containsKey(task.charAt(i))) {
				int last = lastTime.get(task.charAt(i));
				if (count - last <= k) {
					count = last + k + 1;
				}
			}
			lastTime.put(task.charAt(i), count);
		}
		return count;
	}

	public static void main(String[] args){
		String task = "ABCDABAB";
		System.out.println(getTime2(task,2));
	}


	//Followup 1: what if k is small?  maintain a map of size k, 
	// <Charater, Integer> Integer is number of time left for a task to be reactivated

}






