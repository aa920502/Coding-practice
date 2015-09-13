/**
 * Say you have an array for which the ith element is the price of a given
 * stock on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * 
 * Tags: Array, DP
 */
class BestTimeStock {
    /**
     * Optimized bottom-up approach
     * O(n) Time, O(1) Space
     * If next price is bigger, it's only possible to update the profit
     * If next price is smaller or equal, it's only possible to update min
     */
    public static int maxProfit(int[] prices) {
        iif(prices==null||prices.length==0) return 0;
        
        int lowest = prices[0];
        int profit = 0;
        
        for(int i=1;i<prices.length;i++){
            lowest = Math.min(prices[i],lowest);
            profit = Math.max(profit,prices[i]-lowest);
        }
        return profit;
    }
}