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