class MovingAverage {

    int size;
    Queue<Integer> q = new LinkedList<>();

    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        if (q.size()==size) {
            q.remove(); 
        }
        q.add(val);
        int sum =0;
        int divider=0;
        for (int num : q) {
            sum+=num;
            divider++;
        }

        return (double)sum/divider;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
