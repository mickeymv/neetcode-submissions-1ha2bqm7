class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> seenAndCount = new HashMap<>();
        int noOfGoodPairs = 0;
        for(int num:nums) {
            if(seenAndCount.containsKey(num)) {
                int existingCount = seenAndCount.get(num);
                noOfGoodPairs+=existingCount;
                seenAndCount.put(num, existingCount+1);
            } else {
                seenAndCount.put(num,1);
            }
        }

        return noOfGoodPairs;   
    }
}