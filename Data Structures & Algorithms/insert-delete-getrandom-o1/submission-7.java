class RandomizedSet {

    HashMap<Integer,Integer> numToIndex = new HashMap<>();
    ArrayList<Integer> nums = new ArrayList<>();

    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        if (numToIndex.containsKey(val)) {
            return false;
        } else {
            nums.add(val);
            numToIndex.put(val, nums.size()-1);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(numToIndex.containsKey(val)) {
            if (nums.size()==1) {
                nums.removeLast();
                numToIndex.remove(val);
                return true;
            }
            int indexToRemove = numToIndex.get(val);
            int lastIndex = nums.size()-1;
            //put last element at required index and remove last element 
            int elementToSwap = nums.get(lastIndex);
            nums.set(indexToRemove, elementToSwap);
            nums.removeLast(); 
            //update map 
            numToIndex.remove(val);
            numToIndex.put(elementToSwap, indexToRemove);
            return true;
        } else {
            return false;
        }
    }
    
    public int getRandom() {
        int randomIndex = new Random().nextInt(nums.size());
        return nums.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */