class Solution {
    public int uniquePaths(int m, int n) {
        return solve(m-1, n-1, new HashMap<>());
    }

    int solve(int m, int n, Map<String, Integer> memo){
        String key = m+" "+n;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        if(m < 0 || n < 0){
            return 0;
        }
        if(m == 0 && n == 0){
            return 1;
        }
        int sum = solve(m-1, n, memo) + solve(m, n-1, memo);
        memo.put(key, sum);
        return memo.get(key);
    }
}