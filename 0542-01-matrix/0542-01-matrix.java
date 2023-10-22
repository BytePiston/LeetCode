class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0 || mat[0].length == 0)
            return new int[0][0];
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j] == 0)
                    queue.offer(new int[]{i,j});
                else
                    mat[i][j] = Integer.MAX_VALUE;
            }
        }
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            for(int[] dir : directions){
                int newRow = cell[0] + dir[0];
                int newCol = cell[1] + dir[1];
                if(newRow>=0 && newRow<mat.length && newCol>=0 && newCol<mat[0].length && mat[newRow][newCol] > mat[cell[0]][cell[1]] + 1){
                    queue.offer(new int[]{newRow, newCol});
                    mat[newRow][newCol] = mat[cell[0]][cell[1]] + 1;
                }
            }
        }
        return mat;
    }
}