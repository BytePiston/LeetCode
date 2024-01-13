class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.isEmpty()){
            return 0;
        }
        return solveTriangle(triangle, 0, 0, new HashMap<>());
    }
    
    int solveTriangle(List<List<Integer>> triangle, int row, int col, Map<String, Integer> memo){
        
        String key = row + ","+ col;
        if(row == triangle.size()-1 && col < triangle.get(row).size()){
            return triangle.get(row).get(col);
        }
        
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        
        if(row >= triangle.size() || col >= triangle.get(row).size()){
            return Integer.MAX_VALUE;
        }
        int minPath = triangle.get(row).get(col) + Math.min(solveTriangle(triangle, row + 1, col, memo), solveTriangle(triangle, row+1, col+1, memo));
        memo.put(key, minPath);
        return minPath;
    }
}