class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        partitionHelper(s, 0, result, new ArrayList<>());
        return result;
    }
    
    void partitionHelper(String s, int index, List<List<String>> result, List<String> potentialAnswer){
        if(index == s.length()){
            List<String> answer = new ArrayList<>(potentialAnswer);
            result.add(answer);
            return;
        }
        
        for(int part=index; part<s.length(); part++){
            if(isPalindrom(s, index, part)){
                potentialAnswer.add(s.substring(index, part+1));
                partitionHelper(s, part+1, result, potentialAnswer);
                potentialAnswer.remove(potentialAnswer.size()-1);
            }
        }
    }
    
    boolean isPalindrom(String s, int left, int right){
        while(left<right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}