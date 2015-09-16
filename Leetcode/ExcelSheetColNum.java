/**
 * Related to question Excel Sheet Column Title
 * 
 * Given a column title as appear in an Excel sheet, return its corresponding
 * column number.
 * 
 * For example:
 * 
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28 
 * 
 * Tags: Math
 */
class ExcelSheetColNum{
	public static int titleToNumber(String s) {
        if(s==null || s.length()==0)
            return -1;
        int len = s.length();
        int sum = 0;
        for(int i=0;i<s.length();i++){
        	// A-Z  1-26 conversion
        	// AAZ = val(A)*26^2 + val(A)*26^1 + val(Z)*26^0
            sum+=((int)Character.toUpperCase(s.charAt(i))-64)*Math.pow(26,len-1);
            len--;
        }
        return sum;
    }
}