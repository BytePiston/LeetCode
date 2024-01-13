class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.isEmpty()){
            return 0;
        }
        // return solveTriangleRecursive(triangle, 0, 0, new HashMap<>());
        return solveTriangleTabulization(triangle);
    }
    
    //  Tabulization solution with space optimization; 
    //  Bottom -> Up Approach;
    int solveTriangleTabulization(List<List<Integer>> triangle){
        int listSize = triangle.size()-1;
        List<Integer> prevRow = new ArrayList<>(triangle.get(listSize));
        for(int row = listSize-1; row>=0; row--){
            List<Integer> currRow = new ArrayList<>(triangle.get(row));
            for(int i=row; i>=0; i--){
                currRow.set(i, currRow.get(i) + Math.min(prevRow.get(i), prevRow.get(i+1)));
            }
            prevRow = new ArrayList<>(currRow);
        }
        return prevRow.get(0);
    }
    
    //  Recursion with Memoization;
    //  Top -> Down Approach
    int solveTriangleRecursive(List<List<Integer>> triangle, int row, int col, Map<String, Integer> memo){
        
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
        int minPath = triangle.get(row).get(col) + Math.min(solveTriangleRecursive(triangle, row + 1, col, memo), solveTriangleRecursive(triangle, row+1, col+1, memo));
        memo.put(key, minPath);
        return minPath;
    }
}