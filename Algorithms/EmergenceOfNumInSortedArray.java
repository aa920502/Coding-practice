//Given a sorted array, find the emergence of given number.  

import java.util.*;


class EmergenceOfNumInSortedArray{
	// Binary Search
	public static int FindEmergence(int[] input, int num){
		int low = 0;
		int high = input.length-1;

		int res = 0;

		while(low <= high){
			int mid = low + (high - low)/2;
			if(input[mid]==num){
				res = 1;
				int cur = mid+1;
				while(cur<input.length&&input[cur++]==num){
					res ++;
				}
				cur = mid-1;
				while(cur>=0&&input[cur--]==num){
					res ++;
				}
				return res;
			}
			else if(input[mid] < num){
				low = mid+1;
			}
			else{
				high = mid-1;
			}
		}
		return res;
	}

	public static void main(String[] args){
		int[] input = new int[]{1,2,3,3,4,4,4,5,5,5,5,5,5,6,6,7,8,8,9,9,9,10,10};
		for(int i=1; i<=21; i++)
			System.out.println(FindEmergence(input,i));
	}
}