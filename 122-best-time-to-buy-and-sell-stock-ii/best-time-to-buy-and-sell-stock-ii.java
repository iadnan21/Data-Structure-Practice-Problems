class Solution {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int totalProfit = 0;
        for (int i=0; i < prices.length; i++){
            minprice = Math.min(minprice, prices[i]);
            int profit = prices[i] - minprice;
            if(profit > 0){
                totalProfit += profit;
                minprice = prices[i];
            }
        }
        return totalProfit;
    }
}