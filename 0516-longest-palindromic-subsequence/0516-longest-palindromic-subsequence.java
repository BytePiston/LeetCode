class Solution {
    public int longestPalindromeSubseq(String s) {
        String reversedStr = new StringBuilder(s).reverse().toString();
        int[][] memo = new int[s.length()][s.length()];
        for(int[] row: memo){
            Arrays.fill(row, -1);
        }
        return lpsHelper(s.toCharArray(), s.length()-1, reversedStr.toCharArray(), reversedStr.length()-1, memo);
    }
    
    int lpsHelper(char[] charArr1, int index1, char[] charArr2, int index2, int[][] memo){
        if(index1 < 0 || index2 < 0){
            return 0;
        }
        
        if(memo[index1][index2] != -1){
            return memo[index1][index2];
        }
        
        if(charArr1[index1] == charArr2[index2]){
            return memo[index1][index2] = 1 + lpsHelper(charArr1, index1-1, charArr2, index2-1, memo);
        }
        return memo[index1][index2] = 0 + Math.max(lpsHelper(charArr1, index1-1, charArr2, index2, memo), lpsHelper(charArr1, index1, charArr2, index2-1, memo));
    }
}