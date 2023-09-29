class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        solve(result, n, 0, "");
        return result;
    }

    void solve(List<String>result, int lp, int rp, String ps){
        if(lp == 0 && rp == 0){
            result.add(ps);
            return;
        }

        if(lp > 0)
            solve(result, lp-1, rp+1, ps + "(");
        if(rp > 0)
            solve(result, lp, rp-1, ps + ")");
    }
}
