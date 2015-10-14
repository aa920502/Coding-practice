// given a target and a sorted array, find the highest value smaller than the target. 

class HighestSmallerNumInSortedArr{
	//Binary Search
	public static int Largest(int[] nums, int target){
		int low = 0;
		int high = nums.length-1;
		while(low < high){
			int mid = low + (high - low)/2;
			if(nums[mid]==target){
				return nums[mid-1];
			}
			else if(nums[mid]>target){
				if(nums[mid-1]<target) return nums[mid-1];
				high = mid-1;
			}
			else{
				if(nums[mid+1]>target) return nums[mid];
				low = mid+1;
			}
		}
		return 0;
	}

	public static void main(String[] args){
		int[] input = new int[]{1,2,3,4,6,8,9,10,13,15,17,19,24};
		System.out.println(Largest(input,22));
	}
}