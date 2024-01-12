class Solution {
    public int minPathSum(int[][] grid) {
        int rowSize = grid.length;
        int colSize = grid[0].length;
        
        int[][] dp = new int[rowSize][colSize];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        
        return solveMemoized(grid, rowSize-1, colSize-1, dp);
    }
    
    //  Recursive with Memoization;
    int solveMemoized(int[][] grid, int rowSize, int colSize, int[][] dp){    
        if(rowSize < 0 || colSize < 0){
            return 0;
        }
    
        //  Check if current cell has already been computed in DP array;
        if(dp[rowSize][colSize] != -1){
            return dp[rowSize][colSize];
        }
        
        //  If row == 0; meaning reached first row only dir we can move is left; 
        if(rowSize == 0){
            return grid[rowSize][colSize] + solveMemoized(grid, rowSize, colSize-1, dp);
        }
        //  If col == 0; meaning reached first col only dir we can move is up;
        if(colSize == 0){
            return grid[rowSize][colSize] + solveMemoized(grid, rowSize-1, colSize, dp);
        }
        //  Return current cell value + Min(up direction, left direction);
        return dp[rowSize][colSize] = grid[rowSize][colSize] + Math.min(solveMemoized(grid, rowSize-1, colSize, dp), solveMemoized(grid, rowSize, colSize-1, dp));
    }
}