class Solution {
    public boolean validPalindrome(String s) {
        boolean deleteExtraCharUsed = false;

        int left=0, right=s.length()-1;

        while(left<right) {
            if(s.charAt(left)!=s.charAt(right)) {
                //first time, delete a char and check rest of the string 
                return isValid(s,left,right-1) || isValid(s,left+1,right);
            }
            left++;
            right--;
        }

        return true;

    }

    public boolean isValid(String s, int left, int right) {
        while(left<right) {
            if(s.charAt(left)!=s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}