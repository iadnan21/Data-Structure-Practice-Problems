class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Set<Integer> hs = new HashSet<>();

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            hs.add(num);
        }

        List<Integer> al = new ArrayList<>();
        for (int i = min; i < max ; i++){
            if(!hs.contains(i)){
                al.add(i);
            }
        }
        return al;
    }
}