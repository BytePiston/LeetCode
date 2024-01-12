class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //Row and Column size of Input Array obstacleGrid;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        //return solveMemoized(m-1, n-1, dp, obstacleGrid);
        return solveTabulized(m, n, dp, obstacleGrid);
    }
    
    //  Recursive wih Tabulitation;
    int solveTabulized(int m, int n, int[][] dp, int[][] obstacleGrid){
        for(int row=0; row<m; row++){
            for(int col=0; col<n; col++){
                if(row==0 && col==0){
                    dp[row][col] = (obstacleGrid[row][col] == 0) ? 1 : 0;
                } else{
                    if(obstacleGrid[row][col] == 1){
                        dp[row][col] = 0;
                    } else{
                       int up = 0; 
                        int left = 0;
                        if(row>0){
                            up = dp[row-1][col];
                        }
                        if(col>0){
                            left = dp[row][col-1];
                        }
                        dp[row][col] = up + left;   
                    }
                }
            }
        }
        return dp[m-1][n-1];
    }
    
    //  Recursive wih Memoization;
    int solveMemoized(int m, int n, int[][] dp, int[][] obstacleGrid){
        if(m < 0 || n < 0){
            return 0;
        }
        
        if(obstacleGrid[m][n] == 1){
            return 0;
        }
        
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        
        if(m == 0 && n == 0){
            return 1;
        }
        
        return dp[m][n] = solveMemoized(m-1, n, dp, obstacleGrid) + solveMemoized(m, n-1, dp, obstacleGrid);
    }
}