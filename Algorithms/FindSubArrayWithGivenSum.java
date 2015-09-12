// Given an unsorted array of nonnegative integers, find a continous subarray which adds to a given number.

// Examples:

// Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
// Ouptut: Sum found between indexes 2 and 4

// Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
// Ouptut: Sum found between indexes 1 and 4

// Input: arr[] = {1, 4}, sum = 0
// Output: No subarray found


class FindSubArrayWithGivenSum{
	//Time complexity: O(n), Space: O(1)
	public static int subArraySum(int[] arr, int n, int sum){
		int start = 0;
		int cur = arr[0];

		for(int i=1;i<n;i++){
			while(cur > sum && start<i-1){
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
		int[] arr = new int[]{15, 2, 4, 8, 9, 5, 10, 23};
		System.out.println(subArraySum(arr,arr.length,15));
	}
}