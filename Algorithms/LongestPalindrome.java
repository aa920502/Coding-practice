// Find the longest palindrome in a string

class LongestPalindrome{
	int maxLen = 1;
	int maxIndex = 0;
	public String solution(String s){
		if(s==null || s.length()==0) return null;
		for(int i=0; i<s.length(); i++){
			helper(i,0,s,s.length());
			helper(i,1,s,s.length());
		}
		return s.substring(maxIndex,maxIndex+maxLen);
	}

	public void helper(int left, int shift, String s, int len){
		int right = left + shift;
		while(left>=0&&right<len&&s.charAt(left)==s.charAt(right)){
			if(right-left+1>maxLen){
				maxLen = right-left+1;
				maxIndex = left;
			}

			left -- ;
			right ++ ;
		}
	}
}