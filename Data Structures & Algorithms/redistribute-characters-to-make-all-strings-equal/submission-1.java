class Solution {
    public boolean makeEqual(String[] words) {
        //the chars in every word must be equal 

        int noOfWords = words.length;

        int noOfCharsTotal = 0;

        for(int i=0;i<words.length;i++) {
            noOfCharsTotal+=words[i].length();
        }

        //check if there are enough chars per string 

        if(noOfCharsTotal%noOfWords != 0) {
            return false;
        }

        int noOfCharsPerString = noOfCharsTotal/noOfWords;

        HashMap<Character, Integer> charsToFreq = new HashMap<>();

        for(int i=0;i<words.length;i++) {
            for(char ch : words[i].toCharArray()) {
                charsToFreq.put(ch, charsToFreq.getOrDefault(ch, 0)+1);
            }
        }

        for(char ch : charsToFreq.keySet()) {
            int freq = charsToFreq.get(ch);
            if(freq%noOfWords != 0) {
                return false;
            }
        }

        return true;
    }
}