class Solution {
    public String longestPalindrome(String string) {
        //the core idea is to check from the middle of the 
        //palindrome outward, so that we only need to do it for 
        //n chars, and the palindrome check n times, to give an n squared alg 

        String longestPalindrome = "";
        int lengthOfLongestPalindrome = 0;

        //check every char with it being in the middle 
        for (int mid=0; mid < string.length(); mid++) {
            //odd-length palindromes 
            //initialize left and right pointers 
            int left = mid;
            int right = mid;

            while (left >= 0 && right < string.length() 
            && string.charAt(left) == string.charAt(right)) {
                if (right-left+1 > lengthOfLongestPalindrome) {
                    longestPalindrome = string.substring(left, right+1);
                    lengthOfLongestPalindrome = right-left+1;
                }
                left -= 1;
                right +=1;
            }

            //even-length palindromes 
            left = mid;
            right = mid+1;

            while (left >= 0 && right < string.length() 
            && string.charAt(left) == string.charAt(right)) {
                if (right-left+1 > lengthOfLongestPalindrome) {
                    longestPalindrome = string.substring(left, right+1);
                    lengthOfLongestPalindrome = right-left+1;
                }
                left -= 1;
                right +=1;
            }
        }

        return longestPalindrome;
    }
}
