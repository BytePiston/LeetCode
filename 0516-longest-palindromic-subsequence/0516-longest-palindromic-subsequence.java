class Solution {
    public int longestPalindromeSubseq(String s) {
        String rev = reverse(s);
        int[][] dp = new int[s.length()][s.length()];
        for(int i=0; i<dp.length; i++)
            for(int j=0; j<dp.length; j++)
                dp[i][j] = -1;
        return lcs(s, s.length()-1, rev, rev.length()-1, dp);
    }

    String reverse(String s){
        StringBuilder sb = new StringBuilder(s);  
        sb.reverse();  
        return sb.toString();  
    }

    int lcs(String s1, int index1, String s2, int index2, int[][] dp){
        if(index1 < 0 || index2 < 0)
            return 0;
        if(dp[index1][index2] != -1)
            return dp[index1][index2];
        if(s1.charAt(index1) == s2.charAt(index2)){
            dp[index1][index2] = 1 + lcs(s1, index1-1, s2, index2-1, dp);
            return dp[index1][index2];
        }
        dp[index1][index2] = 0 + Math.max(lcs(s1, index1-1, s2, index2, dp), lcs(s1, index1, s2, index2-1, dp));
        return dp[index1][index2];
    }
}