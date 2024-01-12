class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //Row and Column size of Input Array obstacleGrid;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        return solveMemoized(m-1, n-1, dp, obstacleGrid);
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