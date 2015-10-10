//Given two strings S and T, determine if they are both one edit distance apart.

class OneEditDistance {
	// O(n) Time Complexity
	// O(1) Space Complexity
	public static boolean solve(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return solve(s2, s1);
		}
		if (s1.length() + 1 < s2.length()) {
			return false;
		}
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				if (s1.length() == s2.length()) {
					return s1.substring(i + 1).equals(s2.substring(i + 1));
				}
				else {
					return s1.substring(i).equals(s2.substring(i + 1));
				}
			}
		}
		return s1.length() != s2.length();
	}
}


One Edit Distance Iterator

class IntFileIterator {  
	boolean hasNext();  
	int next();
}
class{  
	public boolean isDistanceZeroOrOne(IntFileIterator a, IntFileIterator b)；
}// return if the distance between a and b is at most 1.. 
// Distance: minimum number of modifications to make a=b
// Modification://   1. change an int in a//   2. insert an int to a//   3. remove an int from a



//One edit distance
public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) {
            return false;
        } else if (s.length() > t.length()) {
            return isOneEditDistance(t, s);
        }
        
        if (t.length() - s.length() >= 2) {
            return false;
        }
        int k = t.length() - s.length();
        int index = 0;
        while (index < s.length() && s.charAt(index) == t.charAt(index)) {
            index ++;
        }
        if (index == s.length()) {
            return k == 1;
        }
        if (k == 0) {
            index ++;
        }
        while (index < s.length() && s.charAt(index) == t.charAt(index+k)) {
            index ++;
        }
        return index == s.length();
    }
}

