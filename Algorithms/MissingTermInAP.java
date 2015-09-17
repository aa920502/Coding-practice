// Find missing number in arithmatic progression
// Example: 1 3 7 9   -- > missing 5


class MissingTermInAP{
	public void FindMissing(int[] arr){
		if(arr.length<=2 || arr==null) return;
		Arrays.sort(arr);
		int sum = (arr[0]+arr[arr.length-1])*(arr.length+1)/2;
		for(int i:arr)
			sum -= i;
		System.out.println("The missing number is "+sum);
	}

}