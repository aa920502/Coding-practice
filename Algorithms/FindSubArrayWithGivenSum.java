// Given an unsorted array of nonnegative integers, find a continous subarray which adds to a given number.

// Examples:

// Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
// Ouptut: Sum found between indexes 2 and 4

// Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
// Ouptut: Sum found between indexes 1 and 4

// Input: arr[] = {1, 4}, sum = 0
// Output: No subarray found

import java.util.*;
class FindSubArrayWithGivenSum{
	//Time complexity: O(n), Space: O(1)
	//Assumption: elements are all positive
	public static int subArraySum(int[] arr, int n, int sum){
		int start = 0;
		int cur = arr[0];

		for(int i=1;i<n;i++){
			while(cur > sum && start<i){
				cur = cur - arr[start];
				start ++;
			}
			if(cur == sum){
				System.out.println("Sum found between indexes " + start + " and " + (i-1));
				return 1;
			}
			cur += arr[i];
		}
		System.out.println("Not Found");
		return 0;
	}

	public static void main(String[] args){
		int[] arr = new int[]{7, 22, 4, 8, 9, -5, 10, 23};
		System.out.println(subArraySum2(arr,38));
	}

	// What if the array contains negative number?
    static Boolean subArraySum2(int arr[], int target){
        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
         
        // Initialize sum of elements
        int sum = 0;        
         
        // Traverse through the given array
        for (int i = 0; i < arr.length; i++){   
            // Add current element to sum
            sum += arr[i];
             
            // Return true in following cases
            // a) Current element is 0
            // b) sum of elements from 0 to i is 0
            // c) sum is already present in hash map
            if (arr[i] == target || sum == target || hM.get(sum-target) != null){                            
            	System.out.println(hM.get(sum-target)+1 + " to " + i);
               	return true;
           	}
             
            // Add sum to hash map
            hM.put(sum, i);
        }    
         
        // We reach here only when there is no subarray with 0 sum
        return false;
    }        
}