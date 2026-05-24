class KthLargest {

    int sizeOfMinHeap;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        //create a min heap 
        this.sizeOfMinHeap = k;

        for (int num : nums) {
            this.minHeap.add(num);
            if (this.minHeap.size() > this.sizeOfMinHeap) {
               this.minHeap.poll(); //remove an element from the heap
            }
        }
    }
    
    public int add(int val) {
        this.minHeap.add(val);
        
        if (this.minHeap.size() > this.sizeOfMinHeap) {
            this.minHeap.poll(); //remove k+1th element 
        }
        
        return this.minHeap.peek();
    }
}
