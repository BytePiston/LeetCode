class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length()][text2.length()];
        for(int[] row: memo){
            Arrays.fill(row, -1);
        }
        return lcsHelper(text1.toCharArray(), text1.length()-1, text2.toCharArray(), text2.length()-1, memo);
    }
    
    int lcsHelper(char[] text1Array, int index1, char[] text2Array, int index2, int[][] memo){
        if(index1 < 0 || index2 < 0){
            return 0;
        }
        
        if(memo[index1][index2] != -1){
            return memo[index1][index2];
        }
        
        if(text1Array[index1] == text2Array[index2]){
            return memo[index1][index2] = 1 + lcsHelper(text1Array, index1-1, text2Array, index2-1, memo);
        }
        return memo[index1][index2] = 0 + Math.max(lcsHelper(text1Array, index1-1, text2Array, index2, memo), lcsHelper(text1Array, index1, text2Array, index2-1, memo));
    }
}