class Solution {
    public int[] productExceptSelf(int[] nums) {

        Set<Integer> zeroesWithinNums = new HashSet<>();
        int fullProduct = 1;

        /*if there are more than one zeroes in the input nums array,
        then the output is all zeroes.
        */

        for(int i=0; i< nums.length; i++) {
            if ( nums[i] != 0) {
            fullProduct *= nums[i];
            } else  {
                zeroesWithinNums.add(i);
                if (zeroesWithinNums.size()>1) {
                    break;
                }
            }
        }

        if (zeroesWithinNums.size()>1) {
// return an array of size of nums with all zeroes.
            return new int[nums.length];
        }

                if (zeroesWithinNums.size() == 1) {
// return an array of size of nums with all zeroes.
            int[] result = new  int[nums.length];
            result[zeroesWithinNums.iterator().next()] = fullProduct;
            return result;
        }

        int[] productExceptSelf = new int[nums.length];

        for(int i=0; i< nums.length; i++) {
            if (nums[i] != 0) {
                productExceptSelf[i] = fullProduct/nums[i];
            } else {
                productExceptSelf[i] = fullProduct;
            }
        }

        return productExceptSelf;

 



        }
}  
