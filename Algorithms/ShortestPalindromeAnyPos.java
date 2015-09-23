//Return shortest palindrome, if can insert at any position

//dp[j]存从s到s[j]的substring能够组成的最短palindrome
class ShortestPalindromeAnyPos{
	public static String shortestPalindrome2(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        String[][] dp = new String[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = String.valueOf(s.charAt(i));
        }
        for (int len = 2; len <= s.length(); len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                if (s.charAt(i) == s.charAt(i + len - 1)) {
                    if (len == 2) {
                        dp[i][i + 1] = s.substring(i, i + 2);
                    } else {
                        dp[i][i + len - 1] = s.charAt(i) + dp[i + 1][i + len - 2] + s.charAt(i + len - 1);
                    }
                } else {
                    if (len == 2) {
                        dp[i][i + 1] = s.substring(i, i + 2) + s.charAt(i);
                    } else {
                        dp[i][i + len - 1] = dp[i + 1][i + len - 1].length() < dp[i][i + len - 2].length() ?
                                s.charAt(i) + dp[i + 1][i + len - 1] + s.charAt(i) : s.charAt(i + len - 1) + dp[i][i + len - 2] + s.charAt(i + len - 1);
                    }
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}