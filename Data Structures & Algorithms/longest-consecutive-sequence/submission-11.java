class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();

        for(int num:nums)   {
            numSet.add(num);
        }

        
        int maxStreak=0;

        for(int num:numSet) {
            int streak=1;
            if(!numSet.contains(num-1)){
                //this is the start of the streak 
                while(numSet.contains(num+1)) {
                    num = num+1;
                    streak++;
                }
                maxStreak = Math.max(maxStreak, streak);
            }
        }

        

        return maxStreak;
    }
}
