/*
 A string can be partitioned into some substrings, 
 such that each substring is a palindrome. 
 For example, there are a few strategies to split the string “abbab” into palindrome 
 substrings, such as: “abba”|”b”, “a”|”b”|”bab” and “a”|”bb”|”a”|”b”.

 Given a string str, please get the minimal numbers of splits to partition it into 
 palindromes. The minimal number of splits to partition the string “abbab” into a 
 set of palindromes is 1.

*/

class MinCutsForPalindrome{
	//DP
	// Given a substring ending at the index i, str[0, i], 
	// we do not have to split if the substring is a palindrome itself. 
	// Otherwise it is split between two characters at index j and j+1 
	// only if the substring str[j+1,i] is a palindrome. 
	// Therefore, an equation f(i) can be defined as the following:

	//This solution takes O(n^3) time: palindrome method takes O(n)
	// Can improve to O(n^2) time by preprocessig the str and record 
	// every substring with begin and end for whether it is palindrome


	static int MinSplits(String str){
		int len = str.length();
		int[] split = new int[len];
		for(int i=0; i<len;i++){
			split[i] = i;
		}

		for(int i = 1; i< len; i++){
			if(isPalindrome(str,0,i)){
				split[i] = 0;
				continue;
			}

			// str[0,i] is not a palindrome
			for(int j =0; j<i; j++){
				if(isPalindrome(str,j+1,i) && split[i]>split[j]+1){
					split[i] = split[j] + 1;
				}
			}
		}

		return split[len - 1];
	}

	public static boolean isPalindrome(String str, int begin, int end){
		while(begin <= end){
			if(str.charAt(begin++) != str.charAt(end--)) return false;
		}
		return true;
	}



	public static void main(String[] args){
		String s  = "efgfcdce";
		System.out.println(MinSplits(s));
	}

}