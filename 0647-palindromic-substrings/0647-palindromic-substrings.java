class Solution {
    int totalCount = 0;
    public int countSubstrings(String s) {
        
        for(int i=0; i<s.length(); i++){
            countPalindromicSubstrings(s, i, i);
            countPalindromicSubstrings(s, i, i+1);
        }
        return totalCount;
    }
    
    void countPalindromicSubstrings(String subString, int left, int right){
        while(left>=0 && right<subString.length() && subString.charAt(left) == subString.charAt(right)){
            totalCount++;
            left--;
            right++;
        }     
    }
}