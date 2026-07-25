class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int length = nums.length;

        if (length <= 2) return length;

        int bitMask = 1;
        for (int num : nums) {
            bitMask |= num;
        }
        return bitMask + 1;
    }
}