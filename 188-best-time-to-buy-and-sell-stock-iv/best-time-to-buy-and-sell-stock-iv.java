class Solution {

    int[][][] dp;

    public int solve(int index , int buy , int cap, int [] prices , int k){
        if (index == prices.length || cap == 0){
            return 0;
        }

        if(dp[index][buy][cap] != -1){
            return dp[index][buy][cap];
        }
        int profit;

        if(buy == 1){
            profit = Math.max(-prices[index] + solve(index + 1, 0 , cap, prices , k), solve(index + 1, 1 , cap, prices, k));
        }
        else {
            profit = Math.max(prices[index] + solve(index + 1, 1 , cap - 1, prices , k), solve(index + 1, 0, cap, prices, k));
        }
        return dp[index][buy][cap] = profit;
    }

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        dp = new int[n][2][k + 1];

        for ( int [][] arr : dp){
            for (int [] row : arr){
                Arrays.fill(row , -1);
            }
        }

        return solve(0, 1, k, prices, k);
    }
}