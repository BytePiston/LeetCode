class Solution {
    public List<List<String>> solveNQueens(int n) {
        if(n<1){
            return new ArrayList<>();
        }
        List<List<String>> result = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        solveNQueensHelper(result, 0, board);
        return result;
    }
    
    void solveNQueensHelper(List<List<String>> result, int row, boolean[][] board){
        if(row == board.length){
            result.add(constructBoard(board));
            return;
        }
        
        for(int col=0; col<board[row].length; col++){
            if(isSafeToPlace(board, row, col)){
                board[row][col] = true;
                solveNQueensHelper(result, row+1, board);
                board[row][col] = false;
            }
        }
    }

    boolean isSafeToPlace(boolean[][] board, int row, int col){
        //Validate vertical
        for(int i=0; i<row; i++){
            if(board[i][col]){
                return false;
            }
        }
        
        //Validate left diagnal
        for(int i=1; i<=Math.min(row, col); i++){
            if(board[row-i][col-i]){
                return false;
            }
        }
        
        //Validate right diagnal
        for(int i=1; i<=Math.min(row, board.length-col-1); i++){
            if(board[row-i][col+i]){
                return false;
            }
        }
        return true;
    }
    
    List<String> constructBoard(boolean[][] board){
        List<String> constructedBoard = new ArrayList<>();
        for(int row=0; row<board.length; row++){
            StringBuilder sb = new StringBuilder();
            for(int col=0; col<board[row].length; col++){
                if(board[row][col]){
                    sb.append("Q");
                } else{
                    sb.append(".");
                }
            }
            constructedBoard.add(sb.toString());
        }
        return constructedBoard;
    }
}