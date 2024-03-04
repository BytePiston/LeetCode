class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minPrice = prices[0];
        if(prices == null || prices.length == 0){
            return profit;
        }
        for(int i=0; i<prices.length; i++){
            minPrice = Math.min(prices[i], minPrice);
            profit = Math.max(prices[i] - minPrice, profit);
        }
        return profit;
    }
}