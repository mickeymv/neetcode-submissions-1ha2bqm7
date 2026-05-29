class Solution {
    public boolean validPalindrome(String s) {
        int left=0, right = s.length()-1;

        while(left<right) {
            if (s.charAt(left) != s.charAt(right)) {
                String skipLeft = s.substring(left+1, right+1);
                String skipRight = s.substring(left, right);
                return isPalindrome(skipLeft) || isPalindrome(skipRight);
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        return s.equals(reverse);
    }
}