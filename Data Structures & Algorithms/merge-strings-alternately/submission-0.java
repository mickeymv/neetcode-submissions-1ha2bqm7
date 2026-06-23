class Solution {
    public String mergeAlternately(String word1, String word2) {
        int w1=0,w2=0;

        String word="";

        boolean chooseW1 = true;

        while(w1<word1.length() && w2<word2.length()){
            if(chooseW1) {
                word = word + word1.charAt(w1++);
                chooseW1=false;
            } else {
                word = word + word2.charAt(w2++);
                chooseW1=true;
            }
        }

        while(w1<word1.length()) {
            word = word + word1.charAt(w1++);
        }

        while(w2<word2.length()) {
            word = word + word2.charAt(w2++);
        }

        return word;
    }
}