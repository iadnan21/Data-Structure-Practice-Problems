class Solution {
    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        // half frequencies 
        int[] halffreq = new int[26];
        char middle = '\0';

        for (int i = 0; i < 26; i++) {
            halffreq[i] = freq[i] / 2;

            if (freq[i] % 2 == 1) {
                middle = (char) ('a' + i);
            }
        }

        int halflength = s.length() / 2;

        long[] fact = new long[halflength + 1];
        fact[0] = 1;

        for (int i = 1; i <= halflength; i++) {
            fact[i] = fact[i - 1] * i;
        }

        long totalWays = countWaysSafely(halffreq, k);
        if (totalWays < k) {
            return "";
        }

        StringBuilder left = new StringBuilder();

        while (left.length() < halflength) {
            for (int i = 0; i < 26; i++) {
                if (halffreq[i] == 0) {
                    continue;
                }
                halffreq[i]--;
                long ways = countWaysSafely(halffreq, k);
                if (ways >= k) {
                    left.append((char) ('a' + i));
                    break;
                } else {
                    k -= ways;
                    halffreq[i]++;
                }
            }
        }
        StringBuilder right = new StringBuilder(left).reverse();

        if (middle != '\0') {
            return left.toString() + middle + right.toString();
        } else {
            return left.toString() + right.toString();
        }
    }

    private long countWaysSafely(int[] halfFreq, long limit) {
        int remaining = 0;
        for (int f : halfFreq) {
            remaining += f;
        }

        long ways = 1;

        for (int f : halfFreq) {
            if (f == 0)
                continue;

            ways *= combinationLimited(remaining, f, limit);

            if (ways >= limit) {
                return limit;
            }

            remaining -= f;
        }

        return ways;
    }

    private long combinationLimited(int n, int r, long limit) {
        r = Math.min(r, n - r);

        long result = 1;

        for (int i = 1; i <= r; i++) {
            result = result * (n - r + i) / i;

            if (result >= limit) {
                return limit;
            }
        }

        return result;
    }

}