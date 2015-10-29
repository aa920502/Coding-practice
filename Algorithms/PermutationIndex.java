// Given a permutation which contains no repeated number,
// find its index in all the permutations of these numbers,
// which are ordered in lexicographical order. The index begins at 1.

// Example
// Given [1,2,4], return 1.


class PermutationIndex{
    /**
     * @param A an integer array
     * @return a long integer
     */
    
    // 先弄个(n-1)!的表，再看每个数字后面有几个比他小的，然后点乘

    // 1 2 4:   [2 1] 

    public long permutationIndex(int[] A) {
        if (A == null || A.length == 0) return 0;

        long index = 1;
        long factor = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            int rank = 0;
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) rank++;
            }
            index += rank * factor;
            factor *= (A.length - i);
        }

        return index;
    }	
}