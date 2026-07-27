class Solution {
    public int maxProduct(int[] nums) {
        int total = 0;
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            pqMax.offer(num);
        }
        int a = pqMax.poll() - 1;
        int b = pqMax.poll() - 1;

        total = a * b;
        return total;
    }
}