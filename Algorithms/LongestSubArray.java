//Find longest continuous subarray which sums to target number in an unsorted array, return its length

import java.util.*;
class LongestSubArray{
	// Time: O(n)
	static int LongestSubArray(int arr[], int target){
        HashMap<Integer, LinkedList<Integer>> hM = new HashMap<>();
         
        int sum = 0;        
        int maxLen = -1;
        int start = -1, end = -1;

        for (int i = 0; i < arr.length; i++){   
            sum += arr[i];
         	// 1) If current number is equal to sum
            if (arr[i] == target && maxLen < 1){
        		maxLen = 1;
        		start = i;
        		end = i;
            }
            // 2) cumulative sum up to i is target
            else if(sum == target && maxLen < i+1){
        		maxLen = i+1;
        		start = 0;
        		end = i;
            }
            // 3) exist an index k before i such that subarray [k+1,i] sums to target
            else if(hM.get(sum-target) != null && maxLen < i - hM.get(sum-target).peek()){
        		maxLen = i - hM.get(sum-target).peek();
        		start = hM.get(sum-target).peek()+1;
        		end = i;
            } 
            //Store in map
			if(hM.containsKey(sum)) 
				hM.get(sum).add(i);             
            else{
            	LinkedList<Integer> ll = new LinkedList<>();
            	ll.add(i);
            	hM.put(sum, ll);
            }
        }    

        for(int i=start;i<=end;i++) System.out.print(arr[i]+" ");
        System.out.println();
        return maxLen;
    }  

    public static void main(String[] args){
    	int[] arr = new int[]{3,4,-2,6,-8,2,10,-10};
    	System.out.println(LongestSubArray(arr,0));
    }
}