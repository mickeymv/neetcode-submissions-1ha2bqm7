class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nums3 = new int[nums1.length];

        for(int i=0;i<nums1.length;i++) {
            for(int j=0;j<nums2.length;j++) {
                if(nums1[i]==nums2[j]) {
                    boolean found = false;
                    for(int k=j+1;k<nums2.length;k++) {
                        if(nums2[k]>nums2[j]) {
                            nums3[i]=nums2[k];
                            found = true;
                            break;
                        }
                    }
                    if(!found) {
                        nums3[i]=-1;
                    }
                }
            }
        }

        return nums3;
    }
}