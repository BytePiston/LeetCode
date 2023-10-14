class Solution {
    public boolean isPalindrome(String str) {
        str = str.toLowerCase();
        if(str.isEmpty())
            return true;
        int left = 0;
        int right = str.length()-1;
        while(left<=right){
            char leftCh = str.charAt(left);
            char rightCh = str.charAt(right);
            if(!Character.isLetterOrDigit(leftCh))
                left++;
            else if(!Character.isLetterOrDigit(rightCh))
                right--;
            else{
                if(str.charAt(left) != str.charAt(right))
                    return false;
                else{
                    left++;
                    right--;
                }
            }
        }
        return true;
    }
}