class Solution {
    public boolean isPalindrome(String str) {
        str = str.toLowerCase();
        int s = 0;
        int e = str.length()-1;
        while(s<=e){
            if(!Character.isLetterOrDigit(str.charAt(s)))
                s++;
            else if(!Character.isLetterOrDigit(str.charAt(e)))
                e--;        
            else{if(str.charAt(s) != str.charAt(e))
                return false;
            else{
                 s++;
                 e--;
            }
            }
        }
        return true;
    }
}