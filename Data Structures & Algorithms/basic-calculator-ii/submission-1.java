class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        s = s.replace(" ", "");

        int num = 0;
        char op = '+';

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                num = num*10 + ch - '0';
            }
            if(!Character.isDigit(ch) ||
                i==s.length()-1) {
                    if (op=='+') {
                        stack.push(num);
                    } else if (op=='-') {
                        stack.push(-num);
                    } else if (op=='*') {
                        stack.push(stack.pop()*num);
                    } else { // division '/'
                        stack.push(stack.pop()/num);
                    }

                    num=0;
                    op=ch;
            }
        }

        int res=0;
        while(!stack.isEmpty()){
            res+=stack.pop();
        }
        return res;
    }
}