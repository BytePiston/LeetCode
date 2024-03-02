class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0){
            return 0;
        }
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return numDecodingsHelper(0, s, memo);
    }
    
    int numDecodingsHelper(int index, String inputStr, int[] memo){
        if(index == inputStr.length()){
            return 1;
        }
        char ch = inputStr.charAt(index);
        int len = inputStr.length();
        if(index>len || ch == '0'){
            return 0;
        }
        
        if(memo[index] != -1){
            return memo[index];
        }
        
        int result = 0;
        result += numDecodingsHelper(index+1, inputStr, memo);
        if(index<len-1 && (ch=='1' || ch=='2' && inputStr.charAt(index+1)<'7')){
            result += numDecodingsHelper(index+2, inputStr, memo);
        }
        return memo[index] = result;
    }
}