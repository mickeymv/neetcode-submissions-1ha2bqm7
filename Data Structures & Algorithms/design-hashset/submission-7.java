class MyHashSet {

    List<Integer>[] values = new LinkedList[10_000];

    public MyHashSet() {
        
    }
    
    public void add(int key) {
        int index = key%10_000;

        if(values[index]==null) {
            //no element , add new 
            List<Integer> vals = new LinkedList<>();
            vals.add(key);
            values[index] = vals;
        } else {
            //add to the end of the linkedList or update the correct node 
            List<Integer> vals = values[index];

            for (int val : vals) {
                if (val==key) {
                    //value already exists, do nothing
                    return;
                }
            }

            vals.add(key);
        }
    }
    
    public void remove(int key) {
        int index = key%10_000;

        if (values[index] == null) {
            //no key present, do nothing 
            return;
        } else {
            List<Integer> vals = values[index];
            vals.remove((Integer)key);
        }

    }
    
    public boolean contains(int key) {
        int index = key%10_000;

        if (values[index] == null) {
            //no key present
            return false;
        } else {
            List<Integer> vals = values[index];
            return vals.contains(key);
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */