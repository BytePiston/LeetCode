class Solution {
    public int cherryPickup(int[][] grid) {
        int gridSize = grid.length;
        int[][][] dp = new int[gridSize][gridSize][gridSize];
        int maxCherriesPicked = solveRecursion(grid, 0, 0, 0, dp);
        return  maxCherriesPicked < 0 ? 0 : maxCherriesPicked;
    }
    
    int solveRecursion(int[][] grid, int r1, int c1, int c2, int[][][] dp){
        
        // Using Manhatten Distance formula calculate r2 value;
        int r2 = r1 + c1 - c2;
        int gridSize = grid.length-1;
        
        if(r1>gridSize || r2>gridSize || c1 >gridSize || c2>gridSize || grid[r1][c1] == -1 || grid[r2][c2] == -1){
            return Integer.MIN_VALUE;
        }
        
        if(dp[r1][c1][c2] != 0){
            return dp[r1][c1][c2];
        }
        
        if(r1 == gridSize && c1 == gridSize){
            return grid[r1][c1];
        }
        int maxCherriesPicked = 0;
        
        //  Only adding values from grid[r1][c1];
        maxCherriesPicked = grid[r1][c1];
        
        // If grid[r1][c1] != grid[r2][c2]; i.e: both not at same cell position then add both else pick one;
        if(r1 != r2 && c1 != c2){
            maxCherriesPicked += grid[r2][c2];
        }
        
        //  Manhatten Distance formula will adjust the of missing value;
        //  i.e: for "downdown" only r1 change is provided but for "rightdown" formula will adjust r2 to r2+1 to balance c1+1; 
        int downdown = solveRecursion(grid, r1+1, c1, c2, dp);
        int downright = solveRecursion(grid, r1+1, c1, c2+1, dp);
        int rightdown = solveRecursion(grid, r1, c1+1, c2, dp);
        int rightright = solveRecursion(grid, r1, c1+1, c2+1, dp);
        
        return dp[r1][c1][c2] = maxCherriesPicked + Math.max(downdown, Math.max(downright, Math.max(rightdown, rightright)));
    }
}