class Solution {
    int totalCount = 0;
    public int countSubstrings(String s) {
        for(int i=0; i<s.length(); i++){
            countSubstringsHelper(s, i, i); // odd length
            countSubstringsHelper(s, i, i+1); // even length
        }
        return totalCount;
    }
    
    void countSubstringsHelper(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            totalCount++;
            left--;
            right++;
        }
    }
}