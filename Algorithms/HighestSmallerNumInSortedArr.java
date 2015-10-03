// given a target and a sorted array, find the highest value smaller than the target. 

class HighestSmallerNumInSortedArr{
	//Binary Search
	public static int Largest(int[] nums, int target){
		int low = 0;
		int high = nums.length-1;
		while(low < high){
			int mid = low + (high - low)/2;
			if(nums[mid]>=target){
				if(nums[mid-1]<target) return nums[mid-1];
				else high = mid;
			}
			else{
				low = mid;
			}
		}
		return 0;
	}

	public static void main(String[] args){
		int[] input = new int[]{1,2,3,4,6,8,9,10,13,14,15,17,19};
		System.out.println(Largest(input,12));
	}
}