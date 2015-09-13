/**
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 * 
 * Keys: Whitespaces, Additional chars, Signs, Out of range
 * 
 * Requirements for atoi:
 * The function first discards as many whitespace characters as necessary until
 * the first non-whitespace character is found. Then, starting from this
 * character, takes an optional initial plus or minus sign followed by as many
 * numerical digits as possible, and interprets them as a numerical value.
 * 
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of
 * this function.
 * 
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty
 * or it contains only whitespace characters, no conversion is performed.
 * 
 * If no valid conversion could be performed, a zero value is returned. If the
 * correct value is out of the range of representable values, INT_MAX
 * (2147483647) or INT_MIN (-2147483648) is returned.
 * 
 * Tags: Math, String
 */
class atoi{
	public static int solution(String str){
		int index = 0;
        int total = 0;
        boolean positive = true;

        //1. Empty String
        if(str.length() == 0) return 0;
        //2. Remove Spaces
        while(str.charAt(index) == ' ' && index < str.length()){
            index ++;
        }
        //3. Handle Signs
        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            if(str.charAt(index) == '+')
                positive = true;
            else
                positive = false;
            index ++;
        }
        //4. Convert number and avoid overflow
        while(index < str.length()){
            char ch = str.charAt(index);
            if(ch < '0' || ch > '9') break;
            int digit = ch - '0';
            //check overflow
            if(Integer.MAX_VALUE/10 < total || (Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit))
                return positive?Integer.MAX_VALUE:Integer.MIN_VALUE;
            total = 10*total + digit;
            index ++;
        }
        return positive?total:-total;
	}
}