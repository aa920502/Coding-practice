// Given a sorted array arr[] and a value X, find the k closest elements to X in arr[]. 
// Examples:

// Input: K = 4, X = 35
//        arr[] = {12, 16, 22, 30, 35, 39, 42, 
//                45, 48, 50, 53, 55, 56}
// Output: 30 39 42 45


import java.util.*;
class FindKCLosestElement{
	//  O(Logn + k) time. The idea is to use Binary Search to find the crossover point. 
	//  Once we find index of crossover point, we can print k closest elements in O(k) time.
	public static int binarySearch(int[] arr,int low, int high, int x){
		int mid = 0;
		while(low<=high){
			mid = (high+low)/2;
			if(arr[mid] == x){
				return mid;
			}
			else if(x<arr[mid]){
				high = mid-1;
			}
			else{
				low = mid+1;
			}
		}
		
		return mid;
		
	}

	public static void solution(int[] arr,int x, int k){
		//crosover point
		int cp = binarySearch(arr, 0, arr.length-1, x);
		int left = cp-1;
		int right = cp+1;
		int count = 0;
		
		while(left>=0 && right<arr.length && count <k){
			if(x-arr[left]< arr[right] -x){
				System.out.println(arr[left]);
				left--;
			}
			else{
				System.out.println(arr[right]);
				right++;
			}
			count++;
		}
		
		//if right is over, print all left
		if(right == arr.length){
			while(count<k && left>=0){
				System.out.println(arr[left]);
				left--;
				count++;
			}
		}
		
		//if right is over, print all left
		if(left < 0){
			while(count<k && left>=0){
				System.out.println(arr[right]);
				right++;
				count++;
			}
		}
				
		
	}
	
	public static void main(String[]args){
		
		int[] arr = {1,2,3,4,5,6,7};
	
		int arr1[] = {12, 16, 22, 30, 35, 39, 42,45, 48, 50, 53, 55, 56};
		solution(arr1,55,5);
	}
}