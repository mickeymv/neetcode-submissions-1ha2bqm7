class FirstUnique {

    Queue<Integer> q = new LinkedList<>();
    HashMap<Integer, Integer> numsToCounts = new HashMap<>();
    LinkedHashSet<Integer> uniques = new LinkedHashSet<>();

    public FirstUnique(int[] nums) {
        for (int num: nums) {
            q.add(num);
            numsToCounts.put(num, numsToCounts.getOrDefault(num, 0)+1);
            int count = numsToCounts.get(num);
            if (count==1) {
                uniques.add(num);
            } else if (count==2) { //used to be unique, remove it 
                uniques.remove(num);
        }
        }
    }
    
    public int showFirstUnique() {
        if (uniques.isEmpty()) {
            return -1;
        } else {
            return uniques.getFirst();
        }
    }
    
    public void add(int value) {
        q.add(value);
        numsToCounts.put(value, numsToCounts.getOrDefault(value, 0)+1);
        int count = numsToCounts.get(value);
        if (count==1) {
            uniques.add(value);
        } else if (count==2) { //used to be unique, remove it 
            uniques.remove(value);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
