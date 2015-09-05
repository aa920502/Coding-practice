
public class HeapSort {
	
	private static int N;
	
	public static void HeapSort (int[] arr){
		BuildHeap(arr);
		// Pick out largest one each time, and heapify the rest array
		for (int i = N; i>0; i--){
			Swap(arr,0,i);
			N=N-1;
			Heapify (arr,0);
		}
	}
	public static void BuildHeap (int[] arr){
		N=arr.length -1;
		for (int i = N/2; i>=0; i--){
			Heapify(arr,i);
		}
	}
	
	public static void Heapify(int[] arr, int i){
		int left = 2*i;
		int right = 2*i+1;
		int max = i;
		if (left<= N && arr[left]>arr[i]){
			max = left;
		}
		if (right <= N && arr[right]>arr[max]){
			max = right;
		}
		if(max!= i){
			swap(arr,i,max);
			Heapify(arr,max);
		}
	}
	
	public static void Swap (int[] arr, int a, int b){
		int temp = arr[a];
		arr[a]= arr[b];
		arr[b] = temp;
	}
	
	public static void main(String[] args){
		int[] test = new int[]{5,3,1,321,12,32,324,656,56,85,81,48,47,328,90,67};
		HeapSort(test);
		for(int i =0; i< test.length; i++){
			System.out.println(test[i]);
		}
	}
	
}
