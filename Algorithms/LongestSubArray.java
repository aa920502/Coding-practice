//Find longest continuous subarray which sums to target number in an unsorted array, return its length

class LongestSubArray{
	// Time: O(n)
	static int LongestSubArray(int arr[], int target){
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
         
        int sum = 0;        
        int res = -1;

        for (int i = 0; i < arr.length; i++){   
            sum += arr[i];
         
            if (arr[i] == target) res = Math.max(res,1);
            else if(sum == target) res = Math.max(res,i+1);
            else if(hM.get(sum-target) != null) res = Math.max(res, i - hM.get(sum-target));
             
            hM.put(sum, i);
        }    
         
        return res;
    }  
}