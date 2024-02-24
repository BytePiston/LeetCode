class Solution {
    public int change(int amount, int[] coins) {
        int[][] memo = new int[coins.length+1][amount+1];
        for(int[] row: memo){
            Arrays.fill(row, -1);
        }
        for(int i=0; i<memo.length; i++){
            memo[i][0] = 1;
        }
        return changeHelper(coins, amount, 0, memo);
    }
    
    int changeHelper(int[] coins, int amount, int index, int[][] memo){
        if(amount == 0){
            return 1;
        }
        if(amount<0 || index>coins.length-1){
            return 0;
        }
        if(memo[index][amount] != -1){
            return memo[index][amount];
        }
        int result = 0;
        if(coins[index] <= amount){
            result += changeHelper(coins, amount - coins[index], index, memo);
        }
        result += changeHelper(coins, amount, index+1, memo);
        return  memo[index][amount] = result;
    }
}