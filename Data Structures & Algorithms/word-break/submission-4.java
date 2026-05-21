class Solution {
    Map<Integer, Boolean> canFormWordsAtIndex = new HashMap<>();

    public boolean wordBreak(String string, List<String> wordDict) {
        return canWordBreak(0, string, wordDict);
    }

    public boolean canWordBreak(int index, String string, List<String> wordDict) {
        if (canFormWordsAtIndex.containsKey(index)) {
            return canFormWordsAtIndex.get(index);
        }
        if (index == string.length()) {
            return true;
        }

        for (String word : wordDict) {
            if (index + word.length() <= string.length()) {
                String substring = string.substring(index, index + word.length());
                if (word.equals(substring)) {
                    if (canWordBreak(index + word.length(), string, wordDict)) {
                        canFormWordsAtIndex.put(index, true);
                        return true;
                    }
                }
            }
        }

        canFormWordsAtIndex.put(index, false);
        return false;
    }
}
