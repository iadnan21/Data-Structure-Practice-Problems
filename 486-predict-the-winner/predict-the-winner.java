class Solution {
    int[][] dp;

    public boolean predictTheWinner(int[] nums) {
        int a = nums.length;

        dp = new int[a][a];

        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }

        return maxDiff(0, a - 1, nums, dp) >= 0;
    }

    public int maxDiff(int i, int j, int[] nums, int[][] dp) {
        if (dp[i][j] != -1)
            return dp[i][j];
        if (i == j)
            return dp[i][j] = nums[i];

        return dp[i][j] = Math.max(
                nums[i] - maxDiff(i + 1, j, nums, dp),
                nums[j] - maxDiff(i, j - 1, nums, dp));
    }
}