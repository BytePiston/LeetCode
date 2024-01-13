class Solution {
    public int minFallingPathSum(int[][] matrix) {
        return findMinFallingPathSumTab(matrix);
    }
    
    //  Tabulization with space optimization;
    int findMinFallingPathSumTab(int[][] matrix){
        int[][] dp = new int[matrix.length][matrix[0].length];
        // int[] prevRow = new int[matrix[0].length];
        // int[] currRow = new int[matrix[0].length];
        
        for(int i=0; i<dp[0].length; i++){
            dp[0][i] =  matrix[0][i]; 
        }
        for(int row=1; row<matrix.length; row++){
            for(int col=0; col<matrix[0].length; col++){
                
                int up = matrix[row][col] + dp[row-1][col];
                int leftDiagonal = Integer.MAX_VALUE;
                int rightDiagonal = Integer.MAX_VALUE;
                
                if(col > 0){
                    leftDiagonal = matrix[row][col] + dp[row-1][col-1];
                }
                if(col < dp[row].length-1){
                    rightDiagonal = matrix[row][col] + dp[row-1][col+1];
                }
                dp[row][col] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }
            // prevRow = currRow;
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<dp[0].length; i++){
            min = Math.min(min, dp[dp.length-1][i]);
        }
        return min;
    }
    
    //  Recursion with Memoization;
    int findMinFallingPathSum(int[][] matrix, int row, int col, int[][] dp){
        
        if(row == 0 && col>=0 && col < matrix[0].length){
            return matrix[row][col];
        }
        
        if(row < 0 || col < 0 ||col >= matrix[0].length){
            return Integer.MAX_VALUE;
        }
        
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        
        return dp[row][col] = matrix[row][col] + Math.min(findMinFallingPathSum(matrix, row-1, col, dp), 
                                           Math.min(findMinFallingPathSum(matrix, row-1, col-1, dp), 
                                                    findMinFallingPathSum(matrix, row-1, col+1, dp)));
    }
}