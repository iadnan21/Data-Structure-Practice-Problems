class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= 9; i++) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int num = queue.poll();

            if (num >= low && num <= high) {
                answer.add(num);
            }

            int lastDigit = num % 10;

            if (lastDigit == 9) {
                continue;
            }

            int nextDigit = num * 10 + (lastDigit + 1);

            if (nextDigit <= high) {
                queue.offer(nextDigit);
            }
        }
        return answer;
    }
}