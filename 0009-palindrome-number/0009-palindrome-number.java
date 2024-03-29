class Solution {
    public boolean isPalindrome(int x) {
        String numString = x + "";
        int low = 0;
        int high = numString.length()-1;
        
        while(low < high){
            if(numString.charAt(low) != numString.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}