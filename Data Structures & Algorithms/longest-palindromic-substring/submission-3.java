class Solution {
    public String longestPalindrome(String s) {
        //a string has n^2 substrings, and to check if each 
        //substring is a palindrome takes n time 
        //so we can only achieve this in n^3 best case 

        //every substring of length one is an automatic palindrome 

        if(s.length()==1) {
            return s;
        }

        int maxLength = 1;
        String maxPal=s.substring(0,1);

        for(int i=0;i<s.length();i++) {
            for(int j=i+1;j<=s.length();j++) {
                String sub = s.substring(i,j);
                if(isPal(sub)) {
                    if(sub.length()>maxLength) {
                        maxLength = sub.length();
                        maxPal=sub;
                    }
                }
            }
        }

        return maxPal;

    }

    public boolean isPal(String s) {
        if(s.length()==1) {
            return true;
        }

        for(int l=0,r=s.length()-1; l<r; l++,r--) {
            if(s.charAt(l)!=s.charAt(r)) {
                return false;
            }
        }

        return true;
    }
}
