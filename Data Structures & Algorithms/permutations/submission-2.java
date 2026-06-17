class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> perms = new ArrayList<>();

        if (nums.length==0) {
            perms.add(new ArrayList<>());
            return perms;
        }

        int[] numsWithoutStart = Arrays.copyOfRange(nums, 1, nums.length);

        List<List<Integer>> subPerms = permute(numsWithoutStart);

        int num = nums[0]; //starting number that we need to insert into every index

        for (List<Integer> perm : subPerms) {
            for(int i =0; i<=perm.size();i++){
                List<Integer> permCopy = new ArrayList<>(perm);
                permCopy.add(i,num);
                perms.add(permCopy);
            }
        }

        return perms;
    }
}
