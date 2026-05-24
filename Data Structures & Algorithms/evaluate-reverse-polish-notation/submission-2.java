class Solution {
    public int evalRPN(String[] tokens) {
        HashSet<String> operators = new HashSet<>(Arrays.asList("+", "-", "*","/"));
        
        //if token is a number, add to stack. 
        //if token is an operator, pop 2 from stack and do the operation, then add back to the stack 
        //if we reach end of tokens, then pop back the single int 

        Deque<Integer> stack = new ArrayDeque<>();

        for(int index=0; index<tokens.length; index++) {
            String token = tokens[index];

            if (operators.contains(token)) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                if (token.equals("+")) {
                    stack.push(op1+op2);
                } else if (token.equals("*")) {
                    stack.push(op1*op2);
                } else if (token.equals("-")) {
                    stack.push(op1-op2);
                } else if (token.equals("/")) {
                    if (op2==0) {
                        stack.push(0);
                    } else {
                        stack.push(op1/op2);
                    }
                }
            } else { //token is an int
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.peek();
    }
}
