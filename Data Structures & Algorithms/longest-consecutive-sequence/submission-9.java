class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();

        for(int num:nums)   {
            numSet.add(num);
        }

        List<List<Integer>> listOfSequences = new ArrayList<>();

        for(int num:numSet) {
            List<Integer> sequence = new ArrayList<>();
            sequence.add(num);
            while(numSet.contains(num+1)) {
                num = num+1;
                sequence.add(num);
            }
            listOfSequences.add(sequence);
        }

        int maxSeqLength = 0;

        for(List seq:listOfSequences) {
            maxSeqLength = Math.max(maxSeqLength, seq.size());
        }

        return maxSeqLength;
    }
}
