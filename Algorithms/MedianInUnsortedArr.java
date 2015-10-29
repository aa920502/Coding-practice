// Given an unsorted array, find the median without sorting it

import java.util.*;
class MedianInUnsortedArr{

	//Similar to partition part in Quick Sort
	public static int findK(int[] A, int start, int end, int k) {
        if (end - start <= 0) {
            return A[start];
        }
        int pivot = A[end];
        int j = end-1;
        int p = start;
        while(p<=j) {
            if (A[p] <= pivot) {
                swap(A, p, j);
                j--;
            }
            else p++;
        }
        swap(A, p, end);
        
        if (p - start + 1 == k) {
            return A[p];
        } else if (p - start + 1 > k) {
            return findK(A, start, p - 1, k);
        } else {
            return findK(A, p + 1, end, k - (p - start + 1));
        }
    }

    public static void swap(int[] A, int src, int des) {
        int temp = A[src];
        A[src] = A[des];
        A[des] = temp;
    }

    public static void GetMedian(int[] A){
        if(A.length % 2 ==1)
    	   System.out.println(findK(A,0,A.length-1,(A.length+1)/2));
        if(A.length % 2 == 0)
            System.out.println((findK(A,0,A.length-1,(A.length+1)/2)+findK(A,0,A.length-1,(A.length+1)/2 + 1))/2);
    }

    public static void main(String[] args){
    	int[] tmp = new int[]{10,3,8,2,9,5,7,1,4,6,11};
    	GetMedian(tmp);
    }
}