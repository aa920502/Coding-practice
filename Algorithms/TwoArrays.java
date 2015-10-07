//Given tow arrays, first array contains actual values, second array contains indexes for
// where each element in first array should go, sort this in place

import java.util.*;
class TwoArrays{
	public static void Sort(int[] num, int[] pos){
		for(int i=0; i<pos.length; i++){
			while(i!=pos[i]){
				Swap(num,i,pos[i]);
				Swap(pos,i,pos[i]);
			}
		}
	}

	public static void Swap(int[] arr, int i1, int i2){
		int temp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = temp;
	}

	public static void main(String[] args){
		int[] num = new int[]{5,0,3,2,8};
		int[] pos = new int[]{3,0,2,1,4};
		Sort(num,pos);
		for(int i: num){
			System.out.print(i+" ");
		}
	}
}