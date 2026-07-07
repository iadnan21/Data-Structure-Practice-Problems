class Solution {
    public long sumAndMultiply(int n) {
        int unitPlace = 1;
        long x = 0;
        long sum = 0;

        while (n > 0) {
            int d = n % 10;

            if (d != 0) {
                x = d * unitPlace + x;
                unitPlace *= 10;
                sum += d;
            }
            n /= 10;
        }
        return x * sum;
    }
}