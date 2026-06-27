class Solution {
    public int countSubstrings(String s) {
        
        int palCount = 0;
        
        for(int i=0;i<s.length();i++) {
            //we check every index as the center of a palindromic substring 

            //odd palindromes 

            int left=i,right=i;

            while(left>=0 && right<s.length() 
                    && s.charAt(left)==s.charAt(right)) {
                palCount++;
                left--;
                right++;
            }

            //even 

            left=i;
            right=i+1;
            while(left>=0 && right<s.length() 
                    && s.charAt(left)==s.charAt(right)) {
                palCount++;
                left--;
                right++;
            }
        }

        return palCount;
    }
}
