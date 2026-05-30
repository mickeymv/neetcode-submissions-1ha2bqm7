class MyCircularQueue {

    int front=-1;
    int max=0;
    int size=0;
    int[] q;

    public MyCircularQueue(int k) {
        q = new int[k];
        max = k;
    }
    
    public boolean enQueue(int value) {
        if(size==max){
            return false;
        }
                
        if (size==0) {
            //increment front
            front = (front+1)%max;
        } 

        size++;

        int back = (front+size-1)%max;

        q[back]=value;
        
        return true;
    }
    
    public boolean deQueue() {
        if(size==0){
            return false;
        }
        size--;
        if(size==0) {
            front=-1;
        } else {
            front = (front+1)%max;
        }

        return true;
    }
    
    public int Front() {
        if (size==0) {
            return -1;
        }
        return q[front];
    }
    
    public int Rear() {
        if (size==0) {
            return -1;
        }
        int back = (front+size-1)%max;
        return q[back];
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==max;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */