class DynamicArray {
    private int capacity;
    private int size;

    private int[] array;

    public DynamicArray(int capacity) {
        array = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int i) {
        return array[i];
    }

    public void set(int i, int n) {
        array[i] = n;
    }

       
    public void resize() {
        this.capacity = this.capacity * 2;
        array = Arrays.copyOf(array, this.capacity);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void pushback(int n) {
        if (size == capacity) {
            resize();
        }

        array = Arrays.copyOf(array, ++size);

        array[size-1] = n;
    }

    public int popback() {
        int endOfArrayIndex = size-1;
        size--;
        return array[endOfArrayIndex];
    }

}