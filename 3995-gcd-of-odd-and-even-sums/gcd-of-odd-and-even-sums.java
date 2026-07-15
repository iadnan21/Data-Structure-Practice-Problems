class Solution {

    public int GCD(int a, int b) {
        if (a == 0 || b == 0)
            return Math.max(a, b);

        int result = Math.min(a, b);
        while (result > 0) {
            if (a % result == 0 && b % result == 0) {
                break;
            }
            result--;
        }
        return result;
    }

    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 0;
        int sumEven = 0;

        for (int i = 1; i <= n; i++) {
            sumOdd += (2 * i - 1);
            sumEven += (2 * i);
        }
        return GCD(sumOdd, sumEven);
    }
}