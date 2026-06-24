class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        
        HashSet<HashSet<Integer>> consideredTriplets = new HashSet<>();

        for(int i=0;i<nums.length;i++) {
            int sum = nums[i];
            for(int j=i+1;j<nums.length;j++) {
                if (i==j) {
                    continue;
                }
                for(int k=j+1;k<nums.length;k++) {
                    if (i==k || j==k) {
                        continue;
                    }
                    if(nums[j]+nums[k] + sum == 0) {

                        HashSet<Integer> tripSet = new HashSet<>();
                        tripSet.add(nums[i]);
                        tripSet.add(nums[j]);
                        tripSet.add(nums[k]);

                        if(!consideredTriplets.contains(tripSet)) {
                            List<Integer> triplet = List.of(nums[i], nums[j], nums[k]);
                            triplets.add(triplet);
                            consideredTriplets.add(tripSet);
                        }



                        
                    }
                }
            }
        }

        return triplets;
    }
}
