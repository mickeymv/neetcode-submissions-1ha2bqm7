class Solution {
    public int lengthOfLongestSubstring(String s) {
        int lenOfLongSubStringWithoutDups = 0;

        Set<Character> noDups = new HashSet<>();

        int left=0;

        for(int right=0;right<s.length();right++) {
            while(noDups.contains(s.charAt(right))) {
                noDups.remove(s.charAt(left));
                left++;
            }
            noDups.add(s.charAt(right));
            lenOfLongSubStringWithoutDups = Math.max(lenOfLongSubStringWithoutDups, noDups.size());
        }

        return lenOfLongSubStringWithoutDups;
    }
}
