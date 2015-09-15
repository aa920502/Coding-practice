/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 * 
 * Tags: String
 */

class CountAndSay{
    //Two pointers
    public String countAndSay(int n) {
        String str = "1";
        for(int i=1;i<n;i++){
            str = helper(str);
        }
        return str;
    }
    
    public String helper(String s){
        String ret = "";
        for(int i=0,j=0; j<=s.length();j++){
            if(j<s.length() && s.charAt(i)==s.charAt(j)) continue;
            ret = ret+(j-i)+s.charAt(i);
            i=j;
        }
        return ret;
    }
}