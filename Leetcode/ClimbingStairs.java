/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Tags: DP
 */

public class ClimbingStairs {
    /**
     * Bottom-up approach
     * O(n) time
     * O(1) space
     */
    public int climbStairs(int n) {
        if (n <= 1) return n;
        int last = 1, lastlast = 1;
        int now = 0;
        for (int i = 2; i <= n; i++) {
            now = last + lastlast;
            lastlast = last;
            last = now;
        }
        return now;
    }
}