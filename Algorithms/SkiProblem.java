// Given 2D matrix, find the longest ski path (path with elements in decending ordering)
// Starting point can be any point

// Similar to longest path problem
// Can output the path using memorization


import java.util.*;

class SkiProblem{

	static int[] nextX = {0,1,0,-1};
    static int[] nextY = {1,0,-1,0};
    

    //DP
    public static void helper(int[][] matrix, int[][] dp, int i, int j){
            if(dp[i][j] != 0){
                    return ;
            }
            for(int k = 0; k < 4; k++){
                    int nx = i + nextX[k], ny = j + nextY[k];
                    if(nx >= 0 && nx < matrix.length && ny >= 0 && ny < matrix[0].length && matrix[i][j] > matrix[nx][ny]){
                            if(dp[nx][ny] == 0){
                                    helper(matrix, dp, nx, ny);
                            }
                            dp[i][j] = Math.max(dp[nx][ny] + 1, dp[i][j]);
                    }
            }
            dp[i][j] = dp[i][j] == 0 ? 1 : dp[i][j];
    }
    
    public static int MaxHeight(int[][] matrix){
            if(null == matrix || 0 == matrix.length || 0 == matrix[0].length){
                    return 0;
            }
            int rows = matrix.length, cols = matrix[0].length, max = 0;
            int[][] dp = new int[rows][cols];
            for(int i = 0; i < rows; i++){
                    for(int k = 0; k < cols; k++){
                            helper(matrix, dp, i, k);
                            max = Math.max(max, dp[i][k]);
                    }
            }
            return max;
    }

	public static void main(String[] args){
              int[][] matrix = new int[4][4];
                matrix[0] = new int[]{8,7,5,10};
                matrix[1] = new int[]{10,9,6,7};
                matrix[2] = new int[]{10,10,3,2};
                matrix[3] = new int[]{10,10,4,1};
                System.out.println(MaxHeight(matrix));
        }
}