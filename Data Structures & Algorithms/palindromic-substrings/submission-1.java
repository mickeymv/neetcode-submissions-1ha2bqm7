class Solution {
    public int countSubstrings(String string) {
        //core idea here is that we can check if a substring 
        //is a palindrome by starting at the middle index and then 
        //expanding outward 
        int palindromicSubStrings = 0;

        for (int mid=0; mid<string.length(); mid++) {
            //check through every char in the string 
            //first check odd-length palindromes 
            int left = mid;
            int right = mid;

            while (left>=0 && right <string.length() && string.charAt(left) == string.charAt(right)) {
                palindromicSubStrings++;
                left -= 1;
                right += 1;
            }

            //check even-length palindromes 
            left = mid;
            right = mid+1;

            while (left>=0 && right <string.length() && string.charAt(left) == string.charAt(right)) {
                palindromicSubStrings++;
                left -= 1;
                right += 1;
            }
        }

        return palindromicSubStrings;
    }
}
