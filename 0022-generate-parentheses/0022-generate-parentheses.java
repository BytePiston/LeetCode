class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisHelper(result, n, 0, "");
        return result;
    }

    void generateParenthesisHelper(List<String> result, int leftOpeningCount, int rightClosingCount, String processed){
        
        //  Check if both Left and Right Parenthesis combination are genereted, if so add it to Result List;
        if(leftOpeningCount == 0 && rightClosingCount == 0){
            result.add(processed);
            return;
        }
        
        //  If both Left Parenthesis count is GT 0 then add it to processed String reduce left count and increase right count for generating the matching closing parenthesis;
        if(leftOpeningCount > 0){
            generateParenthesisHelper(result, leftOpeningCount-1, rightClosingCount+1, processed+"(");
        }
        
        //  If both Right Parenthesis count is GT 0 then add it to processed String keep left count as it is decrease right count for generating the matching closing parenthesis;
        if(rightClosingCount > 0){
            generateParenthesisHelper(result, leftOpeningCount, rightClosingCount-1, processed+")");
        }
    }
}
