class Node {
    int val;
    int min;

    public Node(int val, int min) {
        this.val = val;
        this.min = min;
    }
}

class MinStack {
    int top = -1;
    int stackMin = Integer.MAX_VALUE;
    Node[] arr;

    public MinStack() {
        arr = new Node[1000];
    }
    
    public void push(int val) {
        stackMin = Math.min(stackMin, val);
        Node newVal = new Node(val, stackMin);
        arr[++top] = newVal;
    }
    
    public void pop() {
        top--;
        if (top>-1) {
            stackMin = arr[top].min;
        } else {
            stackMin = Integer.MAX_VALUE;
        }
    }
    
    public int top() {
        return arr[top].val;
    }
    
    public int getMin() {
        return stackMin;
    }
}
