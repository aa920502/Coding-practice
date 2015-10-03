// You're given an array of integers(eg [3,4,7,1,2,9,8]) 
// Find the index of values that satisfy A+B = C + D, 
// where A,B,C & D are integers values in the array. 
// Eg: Given [3,4,7,1,2,9,8] array The following 3+7 = 1+ 9 satisfies A+B=C+D 
// so print (0,2,3,5)

import java.util.*;

class APlusBEqualCPlusD{

	static class Pair{
		int x;
		int y;
		public Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	// Use HashMap, O(n^2) solution
	public static List<Integer> Print4Sum(int[] nums){
		HashMap<Integer,Pair> map = new HashMap<>();

		List<Integer> res = new LinkedList<>();

		for(int i=0; i<nums.length-1; i++){
			for(int j =i+1; j<nums.length; j++){
				int sum = nums[i]+nums[j];
				if(!map.containsKey(sum)){
					Pair p = new Pair(i,j);
					map.put(sum,p);
				}
				else{
					int x = map.get(sum).x;
					int y = map.get(sum).y;
					if(x!=i&&x!=j&&y!=i&&y!=j){
						res.add(i);
						res.add(j);
						res.add(x);
						res.add(y);
						return res;
					}
				}
			}
		}
		return res;
	}


	public static void main(String[] args){
		int[] nums = new int[]{3,4,7,1,2,9,8};
		List<Integer> res = APlusBEqualCPlusD.Print4Sum(nums);
		for(int i: res) System.out.println(i);
	}
}