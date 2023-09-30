class Solution {
    public int strStr(String haystack, String needle) {
        String[] arr = haystack.split(needle);
        if(arr.length == 0 || arr[0].isEmpty())
            return 0;
        if(arr[0].length() == haystack.length())
            return -1;
        return arr[0].length();
    }
}