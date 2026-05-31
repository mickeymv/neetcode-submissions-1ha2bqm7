class StockSpanner {

    ArrayList<Integer> prices = new ArrayList<>();

    public StockSpanner() {
        
    }
    
    public int next(int price) {
        prices.add(price);
        int span = 0;
        for(int i = prices.size()-1; i>=0;i--) {
            int priceOnDay = prices.get(i);
            if (priceOnDay<=price) {
                span++;
            } else {
                break;
            }
        }
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */