// Given a binary matrix, find out the maximum size square sub-matrix with all 1s.

// For example, consider the below binary matrix.

 
//    0  1  1  0  1 
//    1  1  0  1  0 
//    0  1  1  1  0
//    1  1  1  1  0
//    1  1  1  1  1
//    0  0  0  0  0
// The maximum square sub-matrix with all set bits is

//     1  1  1
//     1  1  1
//     1  1  1

class MaximumSizeSquareSubMatrix{

	//Time Complexity: O(m*n) where m is number of rows and n is number of columns in the given matrix.
	//Space: O(m*n) where m is number of rows and n is number of columns in the given matrix.

	static void printMaxSubSquare(int[][] matrix){
		int m = matrix.length;
		int n = matrix[0].length;

		int[][] dp = new int[m+1][n+1];
		for(int i = 0; i<m; i++) dp[i][0] = matrix[i][0];
		for(int j = 0; j<n; j++) dp[0][j] = matrix[0][j];

		for(int i = 1; i<m; i++){
			for(int j = 1; j<n; j++){
				if(matrix[i][j]==1)
					dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1]))+1;
				else
					dp[i][j] = 0;
			}
		}

		int ret = 0;
		for(int i = 0; i<=m; i++){
			for(int j = 0; j<=n; j++){
				System.out.print(dp[i][j] +  " ");
				ret = Math.max(ret,dp[i][j]);
			}
			System.out.println();
		}
		System.out.println("size: " + (ret*ret));
	}

	public static void main(String[] args){
		int[][] matrix = new int[6][5];
		matrix[0] = new int[]{0, 1, 1, 0, 1};
		matrix[1] = new int[]{1, 1, 0, 1, 0};
		matrix[2] = new int[]{0, 1, 1, 1, 0};
		matrix[3] = new int[]{1, 1, 1, 1, 0};
		matrix[4] = new int[]{1, 1, 1, 1, 1};
		matrix[5] = new int[]{0, 0, 0, 0, 0};
		printMaxSubSquare(matrix);
	}

}