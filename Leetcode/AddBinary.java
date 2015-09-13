/**
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * 
 * Tags: Math, String
 */

class AddBinary{
	public String addBinary(String a, String b) {
        if(a==null||b==null||a.length()==0||b.length()==0) return null;
        int carry = 0;
        int i = a.length()-1;
        int j = b.length()-1;
        StringBuffer sb = new StringBuffer();

        for(;i>=0||j>=0;i--,j--){
            int sum = (i>=0?a.charAt(i)-'0':0) + (j>=0?b.charAt(j)-'0':0) + carry;
            if(sum>=2){
                sum = sum - 2;
                carry = 1;
            }
            else{
                carry = 0;
            }
            sb.insert(0,sum);
        }
        if (carry == 1) sb.insert(0,1);
        return sb.toString();
    }
}