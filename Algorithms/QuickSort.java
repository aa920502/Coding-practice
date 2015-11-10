// Quick sort implementation

import java.util.*;

class QuickSort{

	//Standard Impl
	public static void quickSort(int[] A, int left, int right) {
        int idx = partition(A, left, right);
        if (left < idx - 1) {
            quickSort(A, left, idx - 1);
        }
        if (idx < right) {
            quickSort(A, idx, right);
        }
    }
    public static int partition(int[] A, int left, int right) {
        int pivot = A[left + (right - left) / 2];
        while (left <= right) {
            while (A[left] < pivot) {
                left++;
            }
            while (A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }

	//Simpler version
	public static void qs(int[] A, int start, int end) {
        if (end - start <= 0) {
            return;
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
        qs(A, start, p - 1);
        qs(A, p + 1, end);
    }
    public static void swap(int[] A, int src, int des) {
        int temp = A[src];
        A[src] = A[des];
        A[des] = temp;
    }

    public static void main(String[] args){
        int[] test = new int[]{4,2,1,3,2,9,10,7,17};
        qs(test,0,test.length-1);
        for(int i: test) System.out.print(i+",");
    }
}