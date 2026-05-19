class Solution {

    Map<Integer, Integer> mem = new HashMap<>();

    public int numDecodings(String s) {
        return dfs(0, s);
    }

    public int dfs(int i, String s) {

        if (mem.containsKey(i)) {
            return mem.get(i);
        }

        //base cases 
        //positive, we reached the end of the string 
        if (i==s.length()) {
            return 1;
        }
        //negative, if the char at i is 0 
        if (s.charAt(i) == '0') {
            return 0;
        }

        //not start at 0, so it is 1-9, so we can process as 1 digit 
        int numDecodings = dfs(i+1, s);

        // we can also process as two digits if 1[0-9] or 2[0-6]
        if (i < s.length()-1) {
            if (s.charAt(i) == '1' || 
            s.charAt(i) == '2' && s.charAt(i+1) < '7') {
                numDecodings += dfs(i+2, s);
            }
        }
        mem.put(i, numDecodings);
        return mem.get(i);
    }
}
