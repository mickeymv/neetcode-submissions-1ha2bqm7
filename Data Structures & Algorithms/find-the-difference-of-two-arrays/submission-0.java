class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> numsIn1NotIn2 = new ArrayList<>();
        List<Integer> numsIn2NotIn1 = new ArrayList<>();

        HashSet<Integer> ones = new HashSet<>();
        HashSet<Integer> twos = new HashSet<>();

        for(int num:nums1) {
            ones.add(num);
        }

        for(int num:nums2) {
            twos.add(num);
        }   

        for(int one:ones) {
            if(!twos.contains(one)) {
                numsIn1NotIn2.add(one);
            }
        }     

        for(int two:twos) {
            if(!ones.contains(two)) {
                numsIn2NotIn1.add(two);
            }
        }   

        List<List<Integer>> result = new ArrayList<>();
        result.add(numsIn1NotIn2);
        result.add(numsIn2NotIn1);

        return result;
    }
}