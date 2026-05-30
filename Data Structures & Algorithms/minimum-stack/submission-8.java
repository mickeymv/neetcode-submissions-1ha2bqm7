class Node {
    int val;
    int min;

    public Node(int val, int min) {
        this.val = val;
        this.min = min;
    }
}

class MinStack {

    Stack<Node> stack = new Stack<>();
    int stackMin = Integer.MAX_VALUE;

    public MinStack() {
        
    }
    
    public void push(int val) {
        stackMin = Math.min(stackMin, val);
        stack.push(new Node(val, stackMin));
    }
    
    public void pop() {
        stack.pop();
        if (stack.isEmpty()) {
            stackMin = Integer.MAX_VALUE;
        } else {
            stackMin = stack.peek().min;
        }
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stackMin;
    }
}
