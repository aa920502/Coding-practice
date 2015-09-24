/*
A network consiting of M cities and M-1 roads, all cities are connected pair wise
Given an array representation 
For example: T[0] = 9  means city 0 connects with city 9, T[1] = 1 means city 1 is capital

Given this array input of size M, return an array of size M-1 specifying the number
of cities positioned at each distance 1,2,..., M-1
*/


import java.util.*;

class Cities{
	public static int[] solution(int[] map){
		HashMap<Integer,ArrayList<Integer>> links = new HashMap<>();
		int capital = 0;
		for(int i = 0; i < map.length; i++){
			int cur = map[i];
			if(cur == i) {capital = cur; continue;}
			if(links.containsKey(cur)){
				links.get(cur).add(i);
			}
			else{
				ArrayList<Integer> level = new ArrayList<>();
				level.add(i);
				links.put(cur,level);
			}
		}
		int[] result = new int[map.length - 1];
		helper(map,capital,links,result);
		return result;
	}

	public static void helper(int[] map, int capital, HashMap<Integer,ArrayList<Integer>> links,int[] result){
		Queue<Integer> queue = new LinkedList<Integer>();
		ArrayList<Integer> start = links.get(capital);
		for(int i = 0; i < start.size(); i++){
			queue.offer(start.get(i));
		}
		int j = 0;
		while(!queue.isEmpty()){
			int size = queue.size();
			result[j] = size;
			j++;
			for(int i=0; i<size; i++){
				int cur = queue.poll();
				if(!links.containsKey(cur)) continue;
				else {
					ArrayList<Integer> neighbors = links.get(cur);
					for(int m: neighbors){
						queue.offer(m);
					}
				}
			}
		}
	}

	public static void main(String[] args){
		int[] test = new int[]{9,1,4,9,0,4,8,9,0,1};
		int[] res = solution(test);
		for(int i=0; i< res.length;i++){
			System.out.println(res[i]);
		}
	}
}