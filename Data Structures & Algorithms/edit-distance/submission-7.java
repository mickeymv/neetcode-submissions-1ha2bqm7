class Solution {
    
    HashMap<String, Integer> cache = new HashMap<>();
    
    public int minDistance(String word1, String word2) {
        return minD(0, 0, word1, word2);
    }

    public int minD(int i, int j, String w1, String w2) {
        if (i==w1.length() && j==w2.length()) {
            return 0;//both words match
        }

        if(i>=w1.length() && j<w2.length()) {
            return w2.length()-j; //remaining chars in w2 need to be deleted 
        }

        if (i<w1.length() && j>=w2.length()) {
            return w1.length()-i;
        }

        String key = i+"-"+j;

        if(cache.containsKey(key)){
            return cache.get(key);
        }

        //if the char is the same, advance the index 
        //without any operation
        if(w1.charAt(i)==w2.charAt(j)) {
            cache.put(key, minD(i+1,j+1,w1,w2));
            return cache.get(key);
        }

        //if the char is not the same 

        cache.put(key, 1 + Math.min(minD(i,j+1,w1,w2),
                            Math.min(minD(i+1,j,w1,w2),
                                        minD(i+1,j+1,w1,w2))));
        
        return cache.get(key);
    }
}
