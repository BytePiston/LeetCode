class Solution {
    int[][] tab;
    public int uniquePaths(int m, int n) {
        tab = new int[m][n];
        for (int[] row: tab)
            Arrays.fill(row, -1);
        return solve(m-1, n-1);
    }

    int solve(int m, int n){
        if(m<0 || n<0)
            return 0;
        else if(m==0 && n==0)
            return 1;
        if(tab[m][n] != -1)
            return tab[m][n];
        tab[m][n] =  solve(m-1,n) + solve(m,n-1);
        return tab[m][n];
    }
}