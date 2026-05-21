class Solution {
    boolean[] canFormWordsAtIndex = null;

    public boolean wordBreak(String string, List<String> wordDict) {
        //create the array till the end of string 
        canFormWordsAtIndex = new boolean[string.length()+1];
        
        //base case the end of the string, which is the end of the word
        canFormWordsAtIndex[string.length()] = true;
        for (int index = string.length()-1; index >= 0; index--) {
            for (String word : wordDict) {
                if (index + word.length() - 1 < string.length()) { // check that the substring length matches the word 
                   String substring = string.substring(index, index + word.length());
                    if (word.equals(substring) && canFormWordsAtIndex[index + word.length()]) {
                        canFormWordsAtIndex[index] = true;
                        break; //found a word, go to next index
                    }
                }
            }
        }

        return canFormWordsAtIndex[0];
    }
}
