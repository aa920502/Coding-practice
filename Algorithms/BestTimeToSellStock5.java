//You can do as many transactions as you want, but after each sell, you need to wait at least one day for next buy;

class BestTimeToSellStock5{
	  public static int maxProfit(int[] prices){
          if(prices == null || prices.length == 0){
                    return 0;
      }
    //整个交易过程中，我们有两种状态，一种是手头只有钱没股票，一种是手头有股票没钱
    //而最后获得最大利润的状态肯定是手头只有钱，所有股票都被抛售的状态
        int[] bear = new int[prices.length];
        //bear position 就是空仓，表示在这个位置我们手头没有股票
        int[] bull = new int[prices.length];
        //bull position 就是满仓，表示在这个位置我们手头已经买了股票，在等待机会抛售
        bear[0] = 0;
        //初始情况，因为手头没股票，所以盈利是0
        bull[0] = 0-prices[0];
        //初始情况，我们钱买了股票，所以是 0-prices[0]. 鍥磋鎴戜滑@1point 3 acres
        for(int i =  1;i<prices.length;i++){
                bear[i] = Math.max(bear[i-1],bull[i-1]+prices[i]);
                //空仓的最大利润的递归式是：bear[i] = max(bear[i-1],bull[i-1]+prices[i]);
                //意思就是当前最大利润应该为前一天空仓的利润（既我们这一天不做任何买卖）和前一天满仓和今天卖出 两者中的最大值
                if(i == 1){. 1point3acres.com/bbs
                        //而对于满仓的话，递归式应该为 bull[i] = max(bull[i-1],bear[i-2]-prices[i])
                        //意思即是 满仓的最大值应该是 前一天满仓，和两天之前空仓今天买入 中的最大值
                        //因为题目限定了要隔一天才能买
                        //对于第一天要单独考虑，因为之前没有买过股票
                        bull[i] = Math.max(bull[0],0-prices[1]);
                }else{
                        bull[i] = Math.max(bull[i-1],bear[i-2]-prices[i]);
                }
        }
        return bear[prices.length-1];
}
}