class Solution {
    
    HashSet<Character> charsInSubString = new HashSet<>();
    
    public int lengthOfLongestSubstring(String s) {

        if (s.length()<=1) {
            return s.length();
        }


        int longestSubstringWithoutRepeats = 0;

        int left=0,right=0;

        while(left>=0 && right<s.length() && left<=right){
            char charToBeAdded = s.charAt(right);
            if(charsInSubString.contains(charToBeAdded)) {
                //update left until that char is removed 
                char leftChar = s.charAt(left);

                while(leftChar!=charToBeAdded) {
                    left++;
                    charsInSubString.remove(leftChar);
                    leftChar = s.charAt(left);
                }

                left++;
                charsInSubString.remove(charToBeAdded);
            }

            charsInSubString.add(charToBeAdded);
            longestSubstringWithoutRepeats = Math.max(longestSubstringWithoutRepeats, charsInSubString.size());
            right++;
        }

        return longestSubstringWithoutRepeats;
    }
}
