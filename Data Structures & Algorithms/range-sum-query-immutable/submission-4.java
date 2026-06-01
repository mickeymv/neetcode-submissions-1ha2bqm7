class NumArray {

    int[] prefixSum;
    public NumArray(int[] nums) {
        prefixSum = new int[nums.length];

        int sum=0;

        for(int i=0;i<nums.length;i++) {
            sum+=nums[i];
            prefixSum[i]=sum;
        }
    }
    
    public int sumRange(int left, int right) {
        int rightPrefixSum = prefixSum[right];

        int leftPrefixSum = 0;

        if (left!=0) {
            leftPrefixSum=prefixSum[left-1];
        }

        return rightPrefixSum-leftPrefixSum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */