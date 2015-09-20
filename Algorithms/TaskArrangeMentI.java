// you have serveral tasks. k is the interval time between two same task. 
// you should keep the order of the tasks
// how much time you should spend to complete all the tasks:
// ABACD, 3 -> 7 because AB__ACD

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
				if (count - last < k) {
					count = last + k;
				}
				lastTime.put(task.charAt(i), count);
			}
			else {
				lastTime.put(task.charAt(i), count);
			}
		}
		return count;
	}
}