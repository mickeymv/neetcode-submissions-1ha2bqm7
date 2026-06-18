class Solution {

    List<String> combinations = new ArrayList<>();
    Map<Integer, String> numsToChars = new HashMap<>();

    {
        numsToChars.put(2, "abc");
        numsToChars.put(3, "def");
        numsToChars.put(4, "ghi");
        numsToChars.put(5, "jkl");
        numsToChars.put(6, "mno");
        numsToChars.put(7, "pqrs");
        numsToChars.put(8, "tuv");
        numsToChars.put(9, "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }

        buildCombinations(0, digits, "");

        return combinations;
    }

    public void buildCombinations(int index, String digits, String currCombination) {
        if (digits.length()==currCombination.length()) {
            combinations.add(currCombination);
            return;
        }

        Integer currDigit = Character.getNumericValue(digits.charAt(index));
        String charsForCurrDigit = numsToChars.get(currDigit);

        for (char ch : charsForCurrDigit.toCharArray()) {
            buildCombinations(index+1, digits, currCombination+ch);
        }
    }
}
