class Solution {
    public int uniquePathsIII(int[][] grid) {
        int rowSize = grid.length;
        int colSize = grid[0].length;
        int startRow = 0;
        int startCol = 0;
        int emptyCell = 0;
        
        for(int row=0; row<rowSize; row++){
            for(int col=0; col<colSize; col++){
                if(grid[row][col] == 1){
                    startRow = row;
                    startCol = col;
                } else if(grid[row][col] == 0){
                    //  Since cells can not be revisited;
                    emptyCell++;
                }
            }
        }
        
        return solveBackTracking(startRow, startCol, emptyCell, grid);
    }
    
    int solveBackTracking(int currRow, int currCol, int emptyCell, int[][] grid) {
        if (currRow < 0 || currCol < 0 || currRow >= grid.length || currCol >= grid[0].length || grid[currRow][currCol] == -1) {
            return 0;
        }
        if (grid[currRow][currCol] == 2) {
            return (emptyCell == -1) ? 1 : 0;  // If all empty cells are used then only return 1 else return 0;
        }
        //  Remember current choice later backtrack both emptyCell and grid cell value and find all the possible directions;
        emptyCell--;
        grid[currRow][currCol] = -1;
    
        int paths = solveBackTracking(currRow + 1, currCol, emptyCell, grid)
                + solveBackTracking(currRow, currCol + 1, emptyCell, grid)
                + solveBackTracking(currRow - 1, currCol, emptyCell, grid)
                + solveBackTracking(currRow, currCol - 1, emptyCell, grid);
        
        grid[currRow][currCol] = 0;
        emptyCell++;
        
        return paths;
    }
}