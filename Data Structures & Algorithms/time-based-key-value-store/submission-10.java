class TimeMap {
    
    HashMap<String, TreeMap<Integer, String>> keyToIntMap = new HashMap<>();

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        if (keyToIntMap.containsKey(key)) {
            TreeMap<Integer, String> intToValue = keyToIntMap.get(key);
            intToValue.put(timestamp, value);
        } else {
            TreeMap<Integer, String> intToValue = new TreeMap<>();
            intToValue.put(timestamp, value);
            keyToIntMap.put(key, intToValue);
        }
    }
    
    public String get(String key, int timestamp) {
        if (keyToIntMap.containsKey(key)) {
            TreeMap<Integer, String> intToValue = keyToIntMap.get(key);
            if (intToValue.containsKey(timestamp)) {
                return intToValue.get(timestamp);
            } else {
                Integer floorKey = intToValue.floorKey(timestamp);
                if (floorKey != null) {
                    return intToValue.get(floorKey);
                } else {
                    return "";
                }
            }
        } else {
            return "";
        }
    }
}
