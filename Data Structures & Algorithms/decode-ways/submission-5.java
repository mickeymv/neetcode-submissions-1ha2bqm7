class Solution {

    Map<Integer, Integer> decodings = new HashMap<>();

    public int numDecodings(String s) {
        return numDecodings(0, s);
    }

    public int numDecodings(int index, String s) {
        if (index>=s.length()) {
            return 1;
        }

        if (s.charAt(index)=='0') {
            return 0;
        }

        if (decodings.containsKey(index)) {
            return decodings.get(index);
        }

        decodings.put(index+1, numDecodings(index+1,s));

        int numDecodings = decodings.get(index+1);//always try the single digit 

        if (index<s.length()-1 &&
            (s.charAt(index)=='1' || 
             (s.charAt(index)=='2' && s.charAt(index+1) < '7'))) {
                decodings.put(index+2, numDecodings(index+2,s));
                numDecodings += decodings.get(index+2);
        }

        decodings.put(index, numDecodings);

        return numDecodings;
    }
}
