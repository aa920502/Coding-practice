// Example: a??ple is written as a2ple,  b????l = b4l
// "b4l" is equal to "babcdl" since ? can represent any character, 
// decide if two input strings are equal


class CompareTwoStrings {
    public boolean solution(String S, String T) {
        if(S==null && T==null) return false;
        if(S==null || S.length()==0) return false;
        if(T==null || T.length()==0) return false;
        //Convert string to form with '?'s and then compare both strings
        String Scur = Convert(S);
        String Tcur = Convert(T);
        
        //Not equal if they have different length
        if(Scur.length()!=Tcur.length()) return false;
        //Linear scan, if there is one index where both have different characters and
        // neither of each has '?' on that position, then the two are different
        for(int i=0;i<Scur.length();i++){
            if(Scur.charAt(i)!=Tcur.charAt(i) 
                && (Scur.charAt(i)!='?' && Tcur.charAt(i)!='?')){
                return false;        
            }
        }
        return true;
    }
    
    public String Convert(String str){
        StringBuilder sb = new StringBuilder(); 
        int i = 0;
        while(i<str.length()){
            //If it is a number, append '?'
            if(Character.isDigit(str.charAt(i))){
                // take care of cases where the string has number greater than 9
                // For example: a12b
                int j = i+1;
                while(j<str.length()&&Character.isDigit(str.charAt(j))){
                    j++;
                }
                int num = Integer.parseInt(str.substring(i,j));
                for(int k=0;k<num;k++){
                    sb.append("?");
                }
                i=j;
            }
            //else, just append the character
            else{
                sb.append(str.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}