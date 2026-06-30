class Solution {
    public int countSubstrings(String s) {
        int count = 0;

        for(int i=0;i<s.length();i++) {


            //consider the index i as the center for each palindrome 
//            we expand outward and check if we are still a palindrome

            //we first start with odd length palindromes 

            int left=i,right=i;
            while(left>=0 && right<s.length()) {
                if(s.charAt(left)==s.charAt(right)) {
                    count++;
                    left--;
                    right++;
                } else {
                    break;
                }
            }

            //next we check even length palindromes 
            left=i;
            right=i+1;

            while(left>=0 && right<s.length()) {
                if(s.charAt(left)==s.charAt(right)) {
                    count++;
                    left--;
                    right++;
                } else {
                    break;
                }
            }
        }

        return count;
    }
}
