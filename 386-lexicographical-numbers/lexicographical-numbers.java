class Solution {
    public List<Integer> lexicalOrder(int n) {
        // DFS approach
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(i, n, answer);
        }
        return answer;
    }

    public void dfs(int current, int n, List<Integer> answer) {
        if (current > n) {
            return;
        }
        answer.add(current);
        for (int digit = 0; digit <= 9; digit++) {
            int nextNum = current * 10 + digit;
            if (nextNum > n) {
                break;
            }
            dfs(nextNum, n, answer);
        }
    }
}