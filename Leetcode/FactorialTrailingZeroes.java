/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Note: Your solution should be in logarithmic time complexity.
 * 
 * Tag: Math
 */

//# of trailing zeros = # of 5 in n....1
//                    = floor(n/5) + floor(n/25) + floor(n/125) + ....
class FactorialTrailingZeroes{
	public int trailingZeroes(int n) {
        int ret =0;
        while(n>0){
            n = n/5;
            if(n==0)
                break;
            ret+=n;
        }
        return ret;
    }
}