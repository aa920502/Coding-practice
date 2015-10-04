
//Return all palindrome substrings in a string
import java.util.*;

class PalindromeSubstrings{

	static HashSet<String> res;

	public static int Partition(String s) {
		
		res = new HashSet<>();
		
		for (int i = 0; i < s.length(); i++) {
			
			// odd length
			for (int l = i, r = i; l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r); l--, r++) 
				res.add(s.substring(l,r+1));

			//even length
			for (int l = i, r = i + 1; l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r); l--, r++) 
				res.add(s.substring(l,r+1));
		}
		return res.size();
	}
	public static void main(String[] args){
		//System.out.println(Partition("aba"));
		System.out.println(Partition("abbafagb"));
		for(String s : res) System.out.println(s);
	}
}