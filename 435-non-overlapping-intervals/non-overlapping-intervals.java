class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int ti = 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int pe = intervals[0][1];

        for(int i=1; i < intervals.length; i++){
            if(intervals[i][0] < pe){
                ti++;
            }else {
                 pe = intervals[i][1];
            }
        }
        return ti;
    }
}