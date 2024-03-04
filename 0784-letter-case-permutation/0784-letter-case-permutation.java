class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        letterCasePermutationHelper(s.toCharArray(), 0, result);
        return result;
    }
    
    void letterCasePermutationHelper(char[] charArray, int index, List<String> result){
        if(index == charArray.length){
            result.add(new String (charArray));
            return;
        }
        if(charArray[index] >= '0' && charArray[index] <= '9'){
            letterCasePermutationHelper(charArray, index+1, result);
            return;
        }
        //lower case scenario;
        charArray[index] = Character.toLowerCase(charArray[index]);
        letterCasePermutationHelper(charArray, index+1, result);
        
        //upper case scenario;
        charArray[index] = Character.toUpperCase(charArray[index]);
        letterCasePermutationHelper(charArray, index+1, result);
    }
}