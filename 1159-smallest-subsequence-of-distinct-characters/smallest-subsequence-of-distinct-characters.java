class Solution {
    public String smallestSubsequence(String s) {
        int length = s.length();
        int[] lastOccurance = new int[26];
        // finding the last occurance of each character 
        for (int i = 0; i < length; i++) {
            lastOccurance[s.charAt(i) - 'a'] = i;
        }

        Deque<Character> stack = new ArrayDeque<>();
        
        // Bit mask for the character presence in the stack.
        int inStackMask = 0;

        for (int i = 0; i < length; i++) {
            char currentChar = s.charAt(i);

            if (((inStackMask >> (currentChar - 'a')) & 1) == 1) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > currentChar && lastOccurance[stack.peek() - 'a'] > i) {
                inStackMask ^= 1 << (stack.pop() - 'a');
            }
            stack.push(currentChar);
            // mark the current character is present in the stack
            inStackMask |= 1 << (currentChar - 'a');
        }

        StringBuilder str = new StringBuilder();
        for (char character : stack) {
            str.append(character);
        }
        return str.reverse().toString();
    }
}