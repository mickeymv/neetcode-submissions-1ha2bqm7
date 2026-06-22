class Solution {
    public String longestCommonPrefix(String[] strs) {
        String lcp="";

        lcp = strs[0];

        for(int i=0;i<lcp.length();i++) {
                boolean breakOut=false;

            for(int si =1; si<strs.length;si++) {
                String str = strs[si];


                if (i>=lcp.length() || i>=str.length() || lcp.charAt(i)!=str.charAt(i)) {
                    breakOut=true;
                    break;
                }

                
            }  
            if(i==0 && breakOut) {
                    return "";
                }

                if (breakOut) {
                    lcp=lcp.substring(0,i);
                    break;
                }       

        }
        return lcp;

    }
}