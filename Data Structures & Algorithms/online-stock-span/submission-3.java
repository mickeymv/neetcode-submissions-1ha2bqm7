class StockSpanner {

    class Node {
        int price;
        int span;

        public Node(int price, int span) {
            this.price = price;
            this.span = span;
        }
    }

    Stack<Node> stack = new Stack<>();

    public StockSpanner() {
        
    }
    
    public int next(int price) {
        int span = 1; //today's price
        while (!stack.isEmpty() && stack.peek().price<=price) {
            Node node = stack.pop();
            span+=node.span;
        }
        stack.push(new Node(price, span));
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */