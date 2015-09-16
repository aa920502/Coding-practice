/**
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return
 * its index.
 * 
 * You may imagine that num[-1] = num[n] = -∞.
 * 
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function
 * should return the index number 2.
 * 
 * Note:
 * Your solution should be in logarithmic complexity.
 * 
 * Tags: Array, Binary Search
 */
class FindPeak {

    // O(n) brute force
	public int findPeakElement(int[] nums) {
        if(nums==null||nums.length<2) return 0;
        if(nums.length==2) return nums[0]>nums[1]?0:1;
        int index = 1;
        while(index<nums.length){
            if(index==nums.length-1){
                if(nums[index]>nums[index-1]) return index;
            }
            if(nums[index]>nums[index-1] && nums[index]>nums[index+1]){
                return index;
            }
            index++;
        }
        return 0;
    }

    //Binary Search - O(logN)
    // Peak element must exist since consecutive elements are all different
    //（1） (> ,>) num[mid] > num[mid - 1], num[mid] > num[mid + 1], clearly mid is peak element
	// (2） (>, <) num[mid] > num[mid - 1], num[mid] < num[mid + 1], [mid + 1.. right] satisfies (>,>) requirement
	//（3） (<, >) num[mid] < num[mid - 1], num[mid] > num[mid + 1], 则[left..mid - 1] satisfies (>,>) requirement
    public int findPeakElement(int[] nums) {
        int left=0,right=nums.length-1;  
        while(left<=right){  
            if(left==right)  
                return left;  
            int mid=(left+right)/2;  
            if(mid>1)
            	if(nums[mid]>nums[mid+1]&&nums[mid]>nums[mid-1]) return mid;
            if(nums[mid]<nums[mid+1])  
                left=mid+1;  
            else  
                right=mid;  
        }  
        return left;
    }
}