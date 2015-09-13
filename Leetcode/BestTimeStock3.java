/**
 * Say you have an array for which the ith element is the price of a given
 * stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most 
 * two transactions.
 * 
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must
 * sell the stock before you buy again).
 * 
 * Tags: Array, DP
 */
class BestTimeStock3 {
    // First record MaxBefore for each i, then go backwards to add two parts together 
    // Time: O(n)  Space: O(n)
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;

        int[] maxBefore = new int[len];
        int min = prices[0];
        for(int i=1; i<len; i++){
            min = Math.min(min, prices[i-1]);
            maxBefore[i] = Math.max(maxBefore[i-1], prices[i] - min);
        }

        int max = prices[len-1];
        int ret = 0;
        for (int i=len-2; i>=0; i--)
        {
            max = Math.max(prices[i+1], max);
            ret = Math.max(ret, max - prices[i] + maxBefore[i]);   
        }
        return ret;
    }
}