/**
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * Given an encoded message containing digits, determine the total number of
 * ways to decode it.
 * 
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 * 
 * Tags: DP, String
 */
class DecodeWays {
	
    //Recursion
    public int numDecodings(String s) {
       if (s.isEmpty()) {
           return 0;
       }
       if (s.length() == 1) {
           if(s.charAt(0) <= '9' && s.charAt(0) >= '1') {
              return 1;
           }
           return0;
       } 
       char ch1 = s.charAt(0);
       int count1 = 0, count2 = 0;
       if (ch1 >= '1' && ch1 <= '9'){
           count1 =numDecodings(s.substring(1));
       }
       if (s.length() >= 2) {
           char ch2_1= s.charAt(0);
           char ch2_2= s.charAt(1);
           if ((ch2_1== '2' && ch2_2 <= '6' && ch2_2 >= '0')||
                 (ch2_1 == '1' && ch2_2 <= '9'&& ch2_2 >= '0')) {
              if(s.substring(2).isEmpty()){
                 count2 = 1;
              } else {
                 count2 = numDecodings(s.substring(2));
              }
           }
       }
       return count1 + count2;
    }


    /**
     * Time O(n), Space O(n)
     * note that there can be zeros in s
     */
	public int numDecodings(String s) {
        if(s==null||s.length()==0) return 0;
        int[] ways = new int[s.length()+1];
        ways[0]=1;
        ways[1]= s.charAt(0)=='0'?0:1;
        for(int i=2;i<=s.length();i++){
            String s1 = s.substring(i-1,i);
            String s2 = s.substring(i-2,i);
            ways[i]=(s1.equals("0")?0:ways[i-1]) + ((Integer.parseInt(s2)>9&&Integer.parseInt(s2)<=26)?ways[i-2]:0);
        }
        return ways[s.length()];
    }

    /**
     * Reduce space to O(1)
     */
    public static int numDecodingsOptimal(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int prev1 = 1;
        int prev2 = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= len; i++) {
            int code1 = Integer.valueOf(s.substring(i - 1, i)); // 1 digit
            int code2 = Integer.valueOf(s.substring(i - 2, i)); // 2 digits
            int temp = prev2;
            prev2 = (code1 != 0 ? prev2 : 0) + (code2 <= 26 && code2 > 9 ? prev1 : 0);
            prev1 = temp;
        }
        return prev2;
    }
}