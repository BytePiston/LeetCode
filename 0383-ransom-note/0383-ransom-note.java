class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(magazine.isEmpty())
            return false;
        else if(ransomNote.isEmpty())
            return true;
        int[] asciiArr = new int[26];
        for(int i=0; i<magazine.length(); i++){
            asciiArr[magazine.charAt(i)-'a']++;
        }
        for(int i=0; i<ransomNote.length(); i++){
            if(asciiArr[ransomNote.charAt(i)-'a']>0)
                asciiArr[ransomNote.charAt(i)-'a']--;
            else
                return false;
        }
        return true;
    }
}