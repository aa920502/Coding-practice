/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 * 
 * Tags: Array, Binary Search
 */

class FindRotatedArrMin {
	//O(n) time
	public int findMin(int[] nums) {
        if(nums==null||nums.length==0) return -1;
        int index = 0;
        while(index<nums.length-1){
            if(nums[index+1]>nums[index]){
                index++;
            }else{
                break;
            }
        }
        if(index==nums.length-1)
            return nums[0];
        return nums[index+1];
    }

	//Binary Search  O(logN) time
	public int findMin(int[] nums) {
       	int low = 0;
		int high = nums.length-1;

		while(low<high){
		    int mid = (low+high)/2;
			if(nums[high]<nums[mid]){
				low=mid+1;
			}
			else{
				high = mid;
			}
		}
		return nums[high];
    }    

}