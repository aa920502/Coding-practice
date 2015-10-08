// you don't need to keep the order of the tasks, find 
// the shortest time you spend to complete all the problems. 

class TaskArrangementII {

	//Node Class
	public static class Node {
		char letter;
		int num;
		public Node(char letter, int num) {
			this.letter = letter;
			this.num = num;
		}
		public static Comparator<Node> NodeComparator = new Comparator<Node>() {
			public int compare(Node a, Node b) {
				return b.num - a.num;
			}
		};
	}

	// Use greedy, count the frequence to each task. 
	// Always choose the valid task with highest frequence. 
	// each time you should also update the frequence. 
	
	public static int getShortestTime(String task, int k) {
		if (task == null || task.length() == 0) return 0;
		if (k == 0) return task.length();
		//Count Frequency
		Map<Character, Node> count = new HashMap<Character, Node>();
		for (int i = 0; i < task.length(); i++) {
			if (count.containsKey(task.charAt(i))) {
				count.get(task.charAt(i)).num++;
			}
			else count.put(task.charAt(i), new Node(task.charAt(i), 1));
		}

		// Initialize priority queue to store all tasks
		PriorityQueue<Node> queue = new PriorityQueue<Node>(count.size(), Node.NodeComparator);
		// Initialize hashmap for each task's last execution time
		Map<Character, Integer> lastTime = new HashMap<Character, Integer>();
		for (char letter : count.keySet()) {
			queue.offer(count.get(letter));
			lastTime.put(count.get(letter).letter, -1);
		}

		int shortestTime = 0;
		StringBuilder result = new StringBuilder();
		while (!queue.isEmpty()) { 
			List<Node> notValid = new ArrayList<Node>();
			Node cur;
			// If current top task in the queue does not fulfill time requirement,
			// temporarily add it to notValid array, try other tasks,
			// at the end, add them back
			while (!queue.isEmpty() && !isValid(shortestTime, lastTime.get(queue.peek().letter), k)) { // worstcase : nlog(n)
				Node tmp = queue.poll();
				notValid.add(tmp);
			}
			//No task executable at this time
			if (queue.isEmpty()) {
				result.append(" ");
				shortestTime++;
			}
			else {
				cur = queue.poll();
				cur.num--; // update remain task number
				lastTime.put(cur.letter, shortestTime); //update last time
				if (cur.num != 0) {
					queue.add(cur);
				}
				result.append(cur.letter);
				shortestTime++;
			}
			for (Node node : notValid) { // worstCase: nlog(n)
				queue.add(node);
			}
		}

		System.out.println(result.toString());
		return shortestTime;
	}
	
	private static boolean isValid(int curTime, int lastTime, int k) {
		if (lastTime == -1) {
			return true;
		}
		return curTime - lastTime > k;
	}
}