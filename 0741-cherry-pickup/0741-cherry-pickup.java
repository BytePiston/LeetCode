class Solution {
    public int cherryPickup(int[][] grid) {
        int[][][] dp = new int[grid.length][grid.length][grid.length];
        int maxCherriesPicked = solveRecursion(grid, 0, 0, 0, dp);
        return maxCherriesPicked < 0 ? 0 : maxCherriesPicked;
    }
    
    int solveRecursion(int[][] grid, int r1, int c1, int c2, int[][][] dp){
        int r2 = r1 + c1 - c2;
        int gridSize = grid.length-1;
        
        if(r1 == gridSize && c1 == gridSize){
            return grid[r1][c1];
        }
        
        if(r1>gridSize || r2>gridSize || c1>gridSize || c2>gridSize || grid[r1][c1] == -1 || grid[r2][c2] == -1){
            return Integer.MIN_VALUE;
        }
        
        if(dp[r1][c1][c2] != 0){
            return dp[r1][c1][c2];
        }
        
        int maxCherriesPicked = grid[r1][c1];
        
        if(r1 != r2 && c1 != c2){
            maxCherriesPicked += grid[r2][c2];
        }
        
        int downDownDir = solveRecursion(grid, r1+1, c1, c2, dp);
        int downRightDir = solveRecursion(grid, r1+1, c1, c2+1, dp);
        int rightDownDir = solveRecursion(grid, r1, c1+1, c2, dp);
        int rightRightDir = solveRecursion(grid, r1, c1+1, c2+1, dp);
        
        return dp[r1][c1][c2] = maxCherriesPicked + Math.max(downDownDir, Math.max(downRightDir, Math.max(rightDownDir, rightRightDir)));
    }
}