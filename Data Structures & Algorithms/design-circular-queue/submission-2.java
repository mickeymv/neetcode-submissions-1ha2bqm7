class MyCircularQueue {

    int maxCapacity = 0;
    int size = 0;
    int[] q;
    int front = -1, back = -1;

    public MyCircularQueue(int k) {
        q = new int[k];
        maxCapacity = k;
    }
    
    public boolean enQueue(int value) {
        if (size == maxCapacity) {
            return false;
        }

        if (size==0) {
            //front==back, increase them both 
            if (back==maxCapacity-1) {
                //we are at the end of the array, need to loop around to the front
                front=0;
                back=0;
            } else {
                front++;
                back++;
            }
        } else if (back==maxCapacity-1) {
            //we are at the end of the array, need to loop around to the front
            back=0;
        } else {
            back++;
        }

        q[back] = value;

        size++;

        return true;
    }
    
    public boolean deQueue() {
        if (size==0) {
            return false;
        }

        if (size==1) {
            //we need to update both front and back 
            front = -1;
            back = -1;
        } else if(front==maxCapacity-1) {
            //we are at the end of the array, need to loop around to the front
            front=0;
        } else {
            front++;
        }
        
        size--;
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

        return q[back];
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size == maxCapacity;
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