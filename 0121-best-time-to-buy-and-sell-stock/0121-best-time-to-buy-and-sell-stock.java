class Solution {
    public int maxProfit(int[] prices) {
        int minValue = prices[0];
        int profit = 0;
        for(int i=0; i<prices.length; i++){
            if(prices[i] < minValue)
                minValue = prices[i];
            if(prices[i] - minValue > profit)
                profit = prices[i] - minValue;
        }
        return profit;
    }
}