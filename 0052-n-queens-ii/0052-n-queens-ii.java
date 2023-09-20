class Solution {
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return solve(board, 0);
    }

    int solve(boolean[][] board, int row){
        if(row == board.length){
            return 1;
        }
        int count = 0;
        for(int col=0; col<board[0].length; col++){
            if(isSafe(board, row, col)){
                board[row][col] = true;
                count += solve(board, row+1);
                board[row][col] = false;
            }
        }
        return count;
    }

    boolean isSafe(boolean[][] board, int row, int col){
        //check for Vertical
        for(int i=0; i<row; i++)
            if(board[i][col])
                return false;

        //check for left diagonal
        for(int i=1; i<=Math.min(row, col); i++)
            if(board[row-i][col-i])
                return false;
        
        //check for right diagonal
        for(int i=1; i<=Math.min(row, board.length-col-1); i++)
            if(board[row-i][col+i])
                return false;

        return true;
    }
}