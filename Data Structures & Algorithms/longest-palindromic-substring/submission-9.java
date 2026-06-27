class Solution {
    public String longestPalindrome(String s) {
        String longestPal = "";

        for(int i=0;i<s.length();i++) {
            //in this loop, we are considering the center for every palindrome 

            //how to consider palindromes of size 1 in this case?



            //odd palindromic length strings 
            int left=i,right=i;

            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)) {
                String subPal = s.substring(left,right+1);
                if(subPal.length()>longestPal.length()) {
                    longestPal = subPal;
                }
                left--;
                right++;
            }

            //to consider even palindromes

            left=i;
            right= i+1;

            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)) {
                String subPal = s.substring(left,right+1);
                if(subPal.length()>longestPal.length()) {
                    longestPal = subPal;
                }
                left--;
                right++;                
            }            
        }

        return longestPal;
    }
}
