/*
Given an array, return the length of longest quasi-sonstant subsequence.

quasi-sonstant subsequence: a subsequence which amplitude does not exceed 1

For example, array: [6,10,6,9,7,8]    subsequence [6,6,7] has amplitude 1

*/

import java.util.*;

class QuasiConstantSubsequence{
	public static int solution(int[] A){
		if(A.length <= 1) return 1;
		HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();

		for(int i=0;i<A.length;i++){
			if(map.containsKey(A[i]+1) || map.containsKey(A[i]-1) || map.containsKey(A[i])){
				if(map.containsKey(A[i]+1)) map.get(A[i]+1).add(i);
				else if(map.containsKey(A[i]-1)) map.get(A[i]-1).add(i);
				else map.get(A[i]).add(i);
			}
			else{
				ArrayList<Integer> arr = new ArrayList<>();
				arr.add(i);
				map.put(A[i],arr);
			}
		}
		int ret = 0;
		for(int key: map.keySet()){
			ret = Math.max(ret,map.get(key).size());
		}
		return ret;
	}

	public static void main(String[] args){
		int[] test = new int[]{6,10,6,9,7,8};
		System.out.println(solution(test));
	}
}