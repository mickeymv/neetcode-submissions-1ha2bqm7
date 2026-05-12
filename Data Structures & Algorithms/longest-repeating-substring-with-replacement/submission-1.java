class Solution {
    public int characterReplacement(String s, int k) {
        //the core idea is that we'd use a sliding window 
        /*
        the sliding window will contain all the same chars, except for 
        k number of chars that can be replaced. 
        once k chars are reached, we move the left pointer to the right, 
        while updating the counts of the character that was just removed from the 
        window (left pointer). 
        we will maintain a hashMap of the frequency of all the alphabets in the 
        sliding window. 
        the sliding window is valid when 
        "length of the window" - "count of most freq char" <= k
        */

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> count = new HashMap<>();
            int maxf = 0;
            for (int j = i; j < s.length(); j++) {
                count.put(s.charAt(j), count.getOrDefault(s.charAt(j), 0) + 1);
                maxf = Math.max(maxf, count.get(s.charAt(j)));
                if ((j - i + 1) - maxf <= k) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    



    }
}
