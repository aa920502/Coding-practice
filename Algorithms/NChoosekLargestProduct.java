//Given n numbers, find k numbers with largest product

class NChoosekLargestProduct{
	public long findLeastProduct(int[] nums, int k) {
		long product = 1;

		Arrays.sort(nums);
		//special case when k is larger than the length or all elements are negative or positive
		if (k >= nums.length || nums[nums.length - 1] <= 0 || nums[0] >= 0) {
			for (int i = nums.length - 1; i >= Math.max(0, nums.length - k); i--) 		{
				product *= nums[i];
			}
		}
		else {
			int l = 0, r = nums.length - 1;
			while (k > 0) {
				if (k == 1) {
					if (nums[r] >= 0) product *= nums[r];
					else product = product / nums[r + 1] * nums[l] * nums[l + 1]; 
					k--;
				} 
				else if (nums[l] * nums[l + 1] > nums[r]) {
					product *= nums[l] * nums[l + 1];
					l += 2;
					k -= 2;
				}
				else {
					product *= nums[r--];
					k--;
				}
			}
		}
		return product;
	}
}