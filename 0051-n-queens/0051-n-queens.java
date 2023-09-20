class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> outer = new ArrayList<>();

        boolean[][] board = new boolean[n][n]; 
        solve(board, outer, 0);
        return outer;
    }

    List<List<String>> solve(boolean[][] board, List<List<String>> outer, int row){

        if(row == board.length){
            outer.add(construct(board));
            return outer;
        }

        for(int col=0; col<board[0].length;col++){
            if(isSafe(board, row, col)){
                board[row][col] = true;
                solve(board, outer, row+1);
                board[row][col] = false;
            }
        }    
        return outer;
    }

    boolean isSafe(boolean[][] board, int row, int col){
        
        //chk vertical;
        for(int i = 0; i< row; i++)
            if(board[i][col])
                return false;

        //chk left diag
        for(int i=1; i<=Math.min(row,col); i++)
            if(board[row-i][col-i])
                return false;

        //chk right diag
        for(int i=1; i<=Math.min(row, board.length-col-1); i++)
            if(board[row-i][col+i])
                return false;
        return true;
    }

    List<String> construct(boolean[][] board){
        List<String> result = new LinkedList<>();
        for(int i=0;i<board.length;i++){
            StringBuilder sb = new StringBuilder();
            for(int j =0; j<board[0].length; j++){
                if(board[i][j])
                    sb.append("Q");
                else
                    sb.append(".");
            }
            result.add(sb.toString());
        }
        return result;
    }
}