class Solution {
    public int climbStairs(int n) {
        int[] allowedSteps = new int[] { 1, 2};
        return find(n, allowedSteps, new HashMap<Integer, Integer>());
    }

    int find(int n, int[] allowedSteps, Map<Integer, Integer> memo){
        int count =0;
        if(memo.containsKey(n))
            return memo.get(n);
        if (n < 0)
            return 0;    
        if(n == 0)
            return 1;
        for(int i = 0; i < allowedSteps.length; i++){
            int res = find(n - allowedSteps[i], allowedSteps, memo);
            if(res>0){
                count += res;
            }
        }
        memo.put(n, count);
        
        return count;
    }
}