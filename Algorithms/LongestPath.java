import java.util.*;

 class LongestPath {
        static int[] nextX = {0,1,0,-1};
        static int[] nextY = {1,0,-1,0};
        
        public static void helper(int[][] matrix, int[][] dp, int i, int j){
                if(dp[i][j] != 0){
                        return ;
                }
                for(int k = 0; k < 4; k++){
                        int nx = i + nextX[k], ny = j + nextY[k];
                        if(nx >= 0 && nx < matrix.length && ny >= 0 && ny < matrix[0].length && matrix[i][j] + 1 == matrix[nx][ny]){
                                if(dp[nx][ny] == 0){
                                        helper(matrix, dp, nx, ny);
                                }
                                dp[i][j] = Math.max(dp[nx][ny] + 1, dp[i][j]);
                        }
                }
                dp[i][j] = dp[i][j] == 0 ? 1 : dp[i][j];
        }
        
        public static int longestPath(int[][] matrix){
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
              int[][] matrix = new int[5][5];
                matrix[0] = new int[]{1 , 2, 3, 4,5};
                matrix[1] = new int[]{16,17,18,19,6};
                matrix[2] = new int[]{15,24,25,20,7};
                matrix[3] = new int[]{14,23,22,21,8};
                matrix[4] = new int[]{13,12,11,10,9};
                System.out.println(longestPath(matrix));
        }
}