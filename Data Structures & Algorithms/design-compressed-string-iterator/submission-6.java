class StringIterator {

    String string;
    char currChar;
    int currFreq=0;

    public StringIterator(String compressedString) {
        string = compressedString;
    }

    public boolean isAplhabet(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }
    
    public char next() {
        if (string.isEmpty()) {
            return ' ';
        }
        if(currFreq==0) {
            //get new char
        char chA = string.charAt(0);
        StringBuilder integer = new StringBuilder();
        int i=1;
        for(; i<string.length(); i++) {
            char ch = string.charAt(i);
            if(!isAplhabet(ch)) {
                integer.append(ch);
            } else {
                break;
            }
        }
        int freq = Integer.parseInt(integer.toString());

        currFreq = freq;
        currChar = chA;

        currFreq--;
        string = string.substring(i, string.length());
        return currChar;

        } else {
            //get saved char
            currFreq--;
            return currChar;
        }
    }
    
    public boolean hasNext() {
        if (string.isEmpty()) {
            return false;
        }
        if(currFreq==0) {
            //get new char
        char chA = string.charAt(0);
        StringBuilder integer = new StringBuilder();
        int i=1;
        for(; i<string.length(); i++) {
            char ch = string.charAt(i);
            if(!isAplhabet(ch)) {
                integer.append(ch);
            } else {
                break;
            }
        }
        int freq = Integer.parseInt(integer.toString());

        currFreq = freq;
        currChar = chA;

        string = string.substring(i, string.length());
        return true;

        } else {
            //get saved char
            return true;
        }
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
