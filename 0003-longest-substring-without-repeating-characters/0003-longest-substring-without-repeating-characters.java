class Solution {
public int lengthOfLongestSubstring(String s) {
    int i = 0, j = 0, max = 0;
    Set<Character> set = new HashSet<>();
    
    while (j < s.length()) {
        char ch = s.charAt(j);
        
        if (!set.contains(ch)) {
            set.add(ch);
            max = Math.max(max, set.size());
            j++;
        } else {
            set.remove(s.charAt(i));
            i++;
        }
    }
    return max;
}

}