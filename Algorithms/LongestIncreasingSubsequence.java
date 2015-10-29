//  * Statement:
//  *  Given a sequence of numbers, find a longest increasing subsequence.
//  *   
//  *  Time Complexity: O(n^2)
//  * 
//  * Sample Input: {8,1,2,3,0,5}
//  * Sample Output: {1,2,3,5}

import java.util.ArrayList;
import java.util.*;
 
public class LongestIncreasingSubsequence {
  //Dynamic Programming
  public static int[] LIS(int[] A) {
    int[] m = new int[A.length];
    
    for (int x = A.length - 2; x >= 0; x--) {
      for (int y = A.length - 1; y > x; y--) {
        if (A[x] < A[y] && m[x] <= m[y]) {
          m[x]=m[y]+1;//or use m[x] = m[y] + 1;
        }
      }
    }
    
    //Get largest length
    int max = m[0];
    for (int i = 1; i < m.length; i++) {
      if (max < m[i]) {
        max = m[i];
      }
    }
    //Store in return array
    int[] result = new int[max+1];
    int index = 0;
    for (int i = 0; i < m.length; i++) {
      if (m[i] == max) {
        result[index++] = A[i];
        max--;
      }
    }
    return result;
  }


  public static void main(String[] args){
    int[] a = { 1, 5, 4, 2, 0, 7, 6 };
    int[] lis = LIS(a);
    System.out.println(Arrays.toString(lis));
  }
}