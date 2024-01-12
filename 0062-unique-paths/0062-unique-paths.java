class Solution {
    public int uniquePaths(int m, int n) {
        int[][] tab = new int[m][n];
        for(int[] row: tab){
            Arrays.fill(row, -1);
        }
        //return solveMemoizated(m-1, n-1, tab);
        return solveTabulation(m, n, tab);
    }
    
    // Iterative solution with Tabulation;
    int solveTabulation(int m, int n, int[][] tab){
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i == 0 && j == 0){
                    tab[i][j] = 1;
                } else{
                    int up = 0;
                    int left = 0;
                    if(i > 0){
                        up = tab[i-1][j];
                    }
                    if(j > 0){
                        left = tab[i][j-1];
                    }
                    tab[i][j] = up + left;
                }
            }
        }
        return tab[m-1][n-1];
    }
    
    //  Recurrsive solution with Memoization;
    int solveMemoizated(int m, int n, int[][] tab){
        
        if(m < 0 || n < 0){
            return 0;
        }
        if(m == 0 && n == 0){
            return 1;
        }
        if(tab[m][n] != -1){
            return tab[m][n];
        }
        tab[m][n] = solveMemoizated(m-1, n, tab) + solveMemoizated(m, n-1, tab);
        return tab[m][n];
    }
}