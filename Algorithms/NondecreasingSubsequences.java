// Problem 1:

// Implement a function nondecreasing_subsequences() that, given a sequence of numbers such as:

//   [ 3,6,61,6,7,9,1,7,7,2,7,7,2,388,3,72,7 ]

// ... will identify and return each contiguous sub-sequence of non-decreasing numbers. 
// E.g. this example input should return this array-of-arrays (e.g. or list-of-lists)

//   [ [3,6,61],[6,7,9],[1,7,7],[2,7,7],[2,388],[3,72],[7] ]

// (Each array includes a sequence of numbers that do not get smaller. The original order is unchanged.) 
// For a visual example of a non-decreasing, see:
// http://en.wikipedia.org/wiki/File:Monotonicity_example1.png


import java.util.*;

class NondecreasingSubsequences{
	public static ArrayList<ArrayList<Integer>> nondecreasing_subsequences(int[] arr){
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		if(arr == null || arr.length == 0) return ret;		
		helper(ret, arr, 0);
		return ret;
	}

	public static void helper(ArrayList<ArrayList<Integer>> ret, int[] arr, int startIndex){
		if(startIndex==arr.length-1) 
			return;

		else {
			ArrayList<Integer> list = new ArrayList<Integer>();
			int first = arr[startIndex];
			list.add(first);
			int j  = startIndex+1;
			while(j<arr.length){
				if(arr[j]>=first){
					list.add(arr[j]);
					first = arr[j++];
				}
				else break;
			}
			ret.add(list);
			if(j==arr.length) return;
			helper(ret,arr,j);
		}
	}

	public static void main(String[] args){
		int[] testarr = new int[]{3,6,61,6,7,9,1,7,7,6,99,99,98,98};
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		ret = nondecreasing_subsequences(testarr);
		for(int i = 0; i<ret.size();i++){
			for(int j = 0; j<ret.get(i).size(); j++){
				System.out.print(ret.get(i).get(j)+",");
			}
			System.out.println();
		}		
	}
} 