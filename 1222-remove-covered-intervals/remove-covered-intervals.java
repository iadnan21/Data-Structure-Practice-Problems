class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int result = 1; 
        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int[] interval : intervals){
            int left = interval[0];
            int right = interval[1];
            if (start < left && end < right){
                start = left;
                result++;
            }
            end = Math.max(end, right);
        }
        return result;
    }
}