class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        return sequentialDigitsHelper(low, high);
    }
    
    List<Integer> sequentialDigitsHelper(int low, int high){
        String digits = "123456789";
        String lowStr = low + "";
        String highStr = high + "";
        int lowLength = lowStr.length();
        int highLength = highStr.length();
        List<Integer> result = new ArrayList<>();
        for(int i=lowLength; i<=highLength; i++){
            for(int j=0; j<10-i; j++){
                int num = Integer.valueOf(digits.substring(j, j+i));
                if(low<=num && num<=high){
                    result.add(num);
                } else if(num>high){
                    return result;
                }
            }
        }
        return result;
    }
}