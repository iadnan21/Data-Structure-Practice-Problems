class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int boxes = boxTypes.length;
        int totalCount = 0;
        for (int[] box : boxTypes) {
            totalCount += Math.min(box[0], truckSize) * box[1];
            truckSize -= Math.min(box[0], truckSize);
            if (truckSize == 0) {
                break;
            }
        }
        return totalCount;
    }
}