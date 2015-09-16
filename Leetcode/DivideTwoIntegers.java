/**
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 * 
 * Tags: Math, Binary Search
 */

//num=a_0*2^0+a_1*2^1+a_2*2^2+...+a_n*2^n
class DivideTwoIntegers{
 	public int divide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        if (dividend == 0) return 0;
        if (divisor == 1) return dividend;
        if (divisor == -1) return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;

        final boolean neg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        
        long ldividend = Math.abs((long)dividend);
        final long ldivisor = Math.abs((long)divisor);
        int res = 0;
        
        for(int bit=Integer.SIZE-1;bit>=0&&ldividend>=ldivisor;bit--){
            if((ldivisor<<bit)<=ldividend){
                ldividend-=ldivisor<<bit;
                res |= 1<<bit;  // set 1 in relative bit in result
            }
        }
        
        return neg?-res:res;
    }
}