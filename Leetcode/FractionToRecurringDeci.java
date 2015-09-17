import java.util.*;

/**
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format.
 * 
 * If the fractional part is repeating, enclose the repeating part in
 * parentheses.
 * 
 * For example,
 * 
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 * 
 * Tags: Hashtable, Math
 */
class FractionToRecurringDeci {
	/**
     * Valid input, denominator can't be zero
     * Convert to long to avoid overflow
     * Divide into three parts, sign, before dot and after dot
     * Before dot = numerator / denominator
     * After dot = remainder * 10 / denominator
     * if already showed up, insert parentheses
     */
	public String fractionToDecimal(int numerator, int denominator) {
        if(denominator==0) return "";
        if(numerator==0) return "0";
        StringBuffer sb = new StringBuffer();
        Long n = new Long(numerator);
        Long d = new Long(denominator);
        if(n*d<0) sb.append("-");
        n=Math.abs(n);
        d=Math.abs(d);
        
        long beforeDot = n/d;
        sb.append(String.valueOf(beforeDot));
        if(n%d==0) return sb.toString();
        
        sb.append(".");
        long r = n%d;
        HashMap<Long,Integer> map = new HashMap<>();
        while(r!=0){
            if(map.containsKey(r)){
                sb.insert(map.get(r),"(");
                sb.append(")");
                break;
            }
            map.put(r,sb.length());
            r*=10;
            sb.append(String.valueOf(r/d));
            r=r%d;
        }
        return sb.toString();
    }

}