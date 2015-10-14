import java.util.*;

class CoinChange{

	public int LeastChange(int[] coins, int target){
		int[] dp = new int[target+1];
		Arrays.fill(dp,target+1);
		dp[0] = 0;

		for(int i = 1; i<=target; i++){
			for(int j = 0; j<coins.length; j++){
				if(coins[j]>i) break;
				else{
					dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
				}
			}
		}

		return dp[target];
	}

	public static void main(String[] args){
		int[] coins = new int[]{2,3,5,6};
		CoinChange c = new CoinChange();
		System.out.println(c.LeastChange(coins,10));
	}
}