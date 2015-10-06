// Given an unsorted array, find the median without sorting it

import java.util.*;
class MedianInUnsortedArr{

	//Similar to partition part in Quick Sort
	public static int findK(int[] A, int start, int end, int k) {
        if (end - start <= 0) {
            return A[start];
        }
        int pivotPos = start + (end - start) / 2;
        int pivot = A[pivotPos];
        swap(A, pivotPos, end);
        int p = start;
        for (int i = start; i < end; i++) {
            if (A[i] <= pivot) {
                swap(A, p, i);
                p++;
            }
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
    	System.out.println(findK(A,0,A.length-1,A.length/2));
    }

    public static void main(String[] args){
    	int[] tmp = new int[]{10,3,8,2,9,5,7,1,4,6};
    	GetMedian(tmp);
    }
}