class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int len = 0;
        for(int i=0; i<s.length(); i++){
            if(!set.add(s.charAt(i))){
                set.remove(s.charAt(i));
                len+=2;
            }
        }
        if(set.isEmpty())
            return len;
        return len + 1;
    }
}