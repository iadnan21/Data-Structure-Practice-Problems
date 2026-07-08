class Solution {
    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        // next non-zero index
        int[] next = new int[n + 1];
        next[n] = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != '0') next[i] = i;
            else next[i] = next[i + 1];
        }

        // previous non-zero index
        int[] prev = new int[n];
        int last = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '0') last = i;
            prev[i] = last;
        }

        // compress non-zero digits
        int m = 0;
        for (char c : s.toCharArray()) {
            if (c != '0') m++;
        }

        int[] digit = new int[m];
        int[] pos = new int[m];
        int[] idx = new int[n];

        int k = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '0') {
                digit[k] = s.charAt(i) - '0';
                pos[k] = i;
                idx[i] = k;
                k++;
            }
        }

        long[] pow10 = new long[m + 1];
        pow10[0] = 1;
        for (int i = 1; i <= m; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        long[] prefNum = new long[m + 1];
        long[] prefSum = new long[m + 1];

        for (int i = 0; i < m; i++) {
            prefNum[i + 1] = (prefNum[i] * 10 + digit[i]) % MOD;
            prefSum[i + 1] = prefSum[i] + digit[i];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int leftPos = next[l];
            if (leftPos == -1 || leftPos > r) {
                ans[i] = 0;
                continue;
            }

            int rightPos = prev[r];

            int L = idx[leftPos];
            int R = idx[rightPos];

            int len = R - L + 1;

            long number =
                    (prefNum[R + 1] - prefNum[L] * pow10[len] % MOD + MOD) % MOD;

            long sum = prefSum[R + 1] - prefSum[L];

            ans[i] = (int) ((number * sum) % MOD);
        }

        return ans;
    }
}