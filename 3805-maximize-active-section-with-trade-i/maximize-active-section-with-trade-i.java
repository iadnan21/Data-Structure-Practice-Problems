class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        // 1000100 => 110001001 => 110000001 => 111111111
        int length = s.length();
        int prev = Integer.MIN_VALUE; // checking the zero segement.
        int maxCount = 0;
        int answer = 0;
        int currentIndex = 0;

        while (currentIndex < length) {
            // System.out.println("1");
            int currentSegmentEnd = currentIndex + 1;
            while (currentSegmentEnd < length && s.charAt(currentSegmentEnd) == s.charAt(currentIndex)) {
                // System.out.println("2");
                currentSegmentEnd++;
            }

            int currentSegmentLength = currentSegmentEnd - currentIndex;
            // System.out.println("3 current");

            if (s.charAt(currentIndex) == '1') {
                // System.out.println("3");
                answer += currentSegmentLength;
            } else {
                // System.out.println("4");
                maxCount = Math.max(maxCount, prev + currentSegmentLength);
                // System.out.println("5");
                prev = currentSegmentLength;
            }
            currentIndex = currentSegmentEnd;
            // System.out.println("6");

        }
        // System.out.println("7");
        answer += maxCount;
        return answer;
    }
}