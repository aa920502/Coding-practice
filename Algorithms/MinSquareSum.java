// A number can always be represented as a sum of squares of other numbers.
// Note that 1 is a square and we can always break a number as (1*1 + 1*1 + 1*1 + …). 
// Given a number n, find the minimum number of squares that sum to X.

// Examples:

// Input:  n = 100
// Output: 1
// 100 can be written as 10^2. Note that 100 can also be 
// written as 5^2 + 5^2 + 5^2 + 5^2, but this
// representation requires 4 squares.

// Input:  n = 6
// Output: 3

class MinSquareSum{

	// Recursive way
	// Exponential time
	public int getMinSquare(int n){
		if(n<=3) return n;

		int res = n;
		for(int i=1;i<=n;i++){
			int temp = i * i;
			if(temp > n) break;
			res = Math.min(res,1+getMinSquare(n-temp));
		}
		return res;
	}

	//DP
	// 1 = 1^2    2 = 1^2 + 1^2   ...
	public int getMinSquare(int n){
		if(n<=0) return 0;
		if(n<=3) return n;

		int[] dp = new int[n+1];
		for(int i=1;i<=3;i++) dp[i]=i;

		for(int i=4;i<=n;i++){
			dp[i] = i;
			for(int x=1; x<i; x++){
				if(x*x>i) break;
				else 
					dp[i] = Math.min(dp[i],1+dp[i-x*x]);
			}
		}
		return dp[n];
	}
}