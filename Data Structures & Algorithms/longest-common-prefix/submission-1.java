class Solution {
    public String longestCommonPrefix(String[] strs) {
        String lcp="";

        lcp = strs[0];

        for(int i=1; i<strs.length;i++) {
            String str = strs[i];

            int j=0;

            for(j=0;j<lcp.length() && j<str.length();j++) {
                if(lcp.charAt(j)!=str.charAt(j)){
                    break;
                }
            }

            if (j==0) {
                return "";
            }

            lcp = lcp.substring(0,j);
        }

        return lcp;
    }
}