class Solution {
    public void moveZeroes(int[] nums) {
        Queue<Integer> zeroIndices = new LinkedList<>();

        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=0 && !zeroIndices.isEmpty()) {
                int zeroIndex = zeroIndices.poll();
                nums[zeroIndex] = nums[i];
                nums[i]=0;
                zeroIndices.add(i);
            } else if (nums[i]==0) {
                zeroIndices.add(i);
            }
        }
    }
}