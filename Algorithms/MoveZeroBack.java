// Move all 0s to the right of an array.
// (1) All the zeroes are at the end of the list
// (2) The order of nonzero elements is preserved. m


public class MoveZeroBack {
	// Function which pushes all zeros to end of an array.
	static void pushZerosToEnd(int arr[]){
	    int count = 0;  // Count of non-zero elements
	 
	    // Traverse the array. If element encountered is non-zero, then
	    // replace the element at index 'count' with this element
	    for (int i = 0; i < arr.length; i++)
	        if (arr[i] != 0)
	            arr[count++] = arr[i]; // here count is incremented
	 
	    // Now all non-zero elements have been shifted to front and 'count' is
	    // set as index of first 0. Make all elements 0 from count to end.
	    while (count < arr.length)
	        arr[count++] = 0;
	}


	// two pointers
	static void pushZerosToEnd(int nums[]){
		if(nums==null||nums.length==0) return;
        int left = 0;
        int right = nums.length-1;
        
        while(left<right){
            while(left<nums.length&&nums[left]!=0){
                left++;
            }
            while(right>=0 && nums[right]==0){
                right--;
            }
            if(left>=right) break;
            else{
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            left++;
            right--;
        }
        return;
	}

	public static void main(String[] args){
		int[] arr = new int[]{0,1,2,3,0,4,5,6,0};
		pushZerosToEnd(arr);
		for(int i:arr) System.out.println(i);
	}
}