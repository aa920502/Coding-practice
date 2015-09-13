// Say you have an array for which the ith element is the price of a given stock on day i.

// Design an algorithm to find the maximum profit. You may complete at most k transactions.

// Note:
// You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).


class BestTimeStock4{
	// DP
    public int maxProfit(int k, int[] prices) {
       if(prices==null || prices.length<2) return 0;
       int len = prices.length;
       // if K is greater than half length, problem becomes《Best Time to Buy and Sell Stock II》-- Greedy
       if(k > (len/2)){
           int prof = 0;
           for(int i = 1; i<len;i++){
               prof += (prices[i]-prices[i-1])>0?prices[i]-prices[i-1]:0;
           }
           return prof;
       }
       
       // local[i][j]: max profit up to day i for transaction j and last transaction is on day i, locally max
       // global[i][j]: max profit up to day i for transaction j, globally max
       
       // local[i][j]=max(global[i-1][j-1]+max(diff,0),local[i-1][j]+diff)  diff=price[i]-price[i-1]; 
       // global[i][j]=max(global[i-1][j],local[i][j]); transaction on day i or not 
       
       int[][] local = new int[len][k+1];
       int[][] global = new int[len][k+1];
       
       for(int i=0;i<len-1;i++){
           int diff = prices[i+1]-prices[i];
           for(int j = 0; j<k;j++){
               local[i+1][j+1] = Math.max(global[i][j]+Math.max(diff,0), local[i][j+1]+diff);
               global[i+1][j+1] = Math.max(global[i][j+1], local[i+1][j+1]);
           }
       }
       return global[len-1][k];
    }
}