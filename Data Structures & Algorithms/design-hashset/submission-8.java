class MyHashSet {

    boolean[] presence;

    public MyHashSet() {
        presence = new boolean[1_000_001];
    }
    
    public void add(int key) {
        presence[key] = true;
    }
    
    public void remove(int key) {
        presence[key] = false;
    }
    
    public boolean contains(int key) {
        return presence[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */