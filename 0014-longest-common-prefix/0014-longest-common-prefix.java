class Solution {
    public String longestCommonPrefix(String[] strs) {
        //  Sort Input Array of String in Lexographic order;
        Arrays.sort(strs);
        
        //  Compare First Elements and Last Elements to compare the Longest Common Prefix;
        String str1 = strs[0];
        String str2 = strs[strs.length-1];
        
        int index = 0;
        
        //Compare each char of First and Last String and with every match of Char increment the index;
        while(index < str1.length() && index < str2.length() && str1.charAt(index) == str2.charAt(index)){
            index++;
        }
        return str1.substring(0,index);
    }
}