class Solution {
    public boolean checkValidString(String s) {
        //we store 2 variables instead of one for openLeftPs. 
        //the first variable is lowLeftPs. whenever we encounter a 
        //wildcard, we decrease lowLeftPs. this is because a wildcard could be 
        //a closing parenthesis. we also increase the other variable, "highLeftPs".
        //this is because a wildcard could be an opening paranthesis. 
        int lowOpenLeftPs = 0, highOpenLeftPs=0;

        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);

            if (ch=='(') {
                highOpenLeftPs++;
                lowOpenLeftPs++;
            } else if (ch==')') {
                if (highOpenLeftPs<1) {
                    return false;//even with wildcards, we cannot balance this closingP 
                } else {
                    highOpenLeftPs--;
                    lowOpenLeftPs = Math.max(0, lowOpenLeftPs-1);
                }
            } else { // when wildcard
                lowOpenLeftPs = Math.max(0, lowOpenLeftPs-1);//as wildcard could be a closingP 
                highOpenLeftPs++; //as wildcard could be a openP
            }
        }

        return lowOpenLeftPs==0;
    }
}
