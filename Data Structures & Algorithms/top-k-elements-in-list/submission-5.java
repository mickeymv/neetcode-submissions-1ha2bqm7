class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> numToCount = new HashMap<>();

        for(int num : nums) {
            numToCount.put(num, numToCount.getOrDefault(num, 0)+1);
        }

        TreeMap<Integer, List<Integer>> countToNums = new TreeMap<>();

        for(int num: numToCount.keySet()) {
            int numCount = numToCount.get(num);
            if (countToNums.containsKey(numCount)) {
                List<Integer> numsWithSameCount = countToNums.get(numCount);
                numsWithSameCount.add(num);
            } else {
                List<Integer> numsWithSameCount = new ArrayList<>();
                numsWithSameCount.add(num);
                countToNums.put(numCount, numsWithSameCount);
            }
        }

        List<Integer> kMostFreqNums = new ArrayList<>();

        int highestCount = countToNums.lastKey();

        while(k>0 && highestCount!=-1) {
            List<Integer> numsWithSameCount = countToNums.get(highestCount);
            for(int i=0;k>0 && i<numsWithSameCount.size();i++,k--) {
                kMostFreqNums.add(numsWithSameCount.get(i));
            }
            if (countToNums.lowerKey(highestCount)!=null) {
                highestCount = countToNums.lowerKey(highestCount);
            } else {
                highestCount = -1;
            }
            
        }

        return kMostFreqNums.stream().mapToInt(Integer::intValue).toArray();
    }
}
