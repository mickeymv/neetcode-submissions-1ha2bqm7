class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s==null || s.length()==0) {
            return 0;
        }

        if (s.length()==1) {
            return 1;
        }

        int maxSubString = 1;
        Map<Character, Integer> charToIndex = new HashMap<>();

        int left=0,right=0;

        while(left<=right && right<s.length()) {
            char rightChar = s.charAt(right);
            if(charToIndex.containsKey(rightChar)) {
                //the window already contains the rightChar, advance left to 
                //that earlier occurence+1 , and remove those chars from the map 
                int earlierRightIndex = charToIndex.get(rightChar);
                while(left<=earlierRightIndex) {
                    char leftChar = s.charAt(left);
                    charToIndex.remove(leftChar);
                    left++;
                }
            }
            charToIndex.put(rightChar, right);
            maxSubString = Math.max(maxSubString, charToIndex.size());
            right++;
        }

        return maxSubString;
    }
}
