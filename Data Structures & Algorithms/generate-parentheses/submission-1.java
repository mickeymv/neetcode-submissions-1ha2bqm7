class Solution {

    List<String> pStrings = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        addParanthesis(n, 0, 0, "");
        return pStrings;
    }

    public void addParanthesis(int n, int open, int close, String cur) {
        if (open==n && close==n) {
            pStrings.add(new String(cur));
            return;
        } 

        if (open<n) {
            //add an open
            addParanthesis(n, open+1, close, cur+"(");
        }

        if (close<open) {
            //add a close
            addParanthesis(n, open, close+1, cur+")");
        }
    }
}
