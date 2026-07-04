class Solution {
    int[][][] dp;

    public int solve(int index, int buy, int cap, int[] prices) {
        if (index == prices.length || cap == 0) {
            return 0;
        }

        if (dp[index][buy][cap] != -1) {
            return dp[index][buy][cap];
        }
             
         int profit;     
        if (buy == 1) {
            // buy
            profit =  Math.max(-prices[index] + solve(index + 1, 0, cap, prices), solve(index + 1, 1, cap, prices));
        } else {
            // sell
            profit = Math.max(prices[index] + solve(index + 1, 1, cap - 1, prices), solve(index + 1, 0, cap, prices));
        }

        return dp[index][buy][cap] = profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;

        // 3d dp approach
        // 1. index of prices 
        // 2. buy = B / S
        // 3. cap of transaction buy , sell , skip  
        dp = new int[n][2][3];

        for (int[][] arr : dp){
            for (int [] row : arr){
                Arrays.fill(row, -1);
            }
        }

        return solve(0, 1, 2, prices);
    }
}