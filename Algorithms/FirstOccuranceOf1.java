// Given 000001111111, find first occurance of 1

class FirstOccuranceOf1{

	//Binary search 
	public static int Find(int[] input){
		int low = 0;
		int high = input.length-1;

		while(low < high){
			int mid = low + (high - low)/2;
			if(input[mid]==0){
				low = mid+1;
			}
			else{
				high = mid;
			}
		}
		return low;
	}

	public static void main(String[] args){
		int[] test = new int[]{0,0,0,0,1,1,1,1,1};
		System.out.println(Find(test));
	}
}