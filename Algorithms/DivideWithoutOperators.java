/*
 * We start by shifting the divisor left until it's greater than the dividend. 
 * We then repeatedly shift it right and for each right shift check whether that value is less than 
 * the intermediate we got after the last subtraction. If it's less, we subtract again and fill in a 
 * 1 for that digit in our result. 
 * If it's greater, we "subtract 0" (don't do anything) and fill in a '0' 
 * for that digit in the result (which, again, doesn't require us to do anything, 
 * since those digits are already set to 0's).
 */
public class DivideWithoutOperators {
	public static int divide (int divident, int divisor){
		int denom = divisor;
		int count = 1;
		int answer = 0;
		
		// handle two special cases first
		if (denom > divident) return 0;
		if (denom == divident) return 1;
		
		while (denom < divisor){
			denom <<= 1;
			count <<= 1;
		}
		denom >>= 1;
		count >>= 1;
			
		while (count != 0){
			if (denom <= divident){
				divident -= denom;
				answer |= count;
			}
			denom >>= 1;
			count >>=1;
		}
		return answer;
	}
}
