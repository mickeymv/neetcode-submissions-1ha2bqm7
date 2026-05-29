

class TimeMap {

    HashMap<String, TreeMap<Integer, String>> keyToTimesToValues = new HashMap<>();

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        if (keyToTimesToValues.containsKey(key)) {
            TreeMap<Integer, String> timesToValues = keyToTimesToValues.get(key);
            timesToValues.put(timestamp, value);
        } else {
            TreeMap<Integer, String> timesToValues = new TreeMap<>();
            timesToValues.put(timestamp, value);
            keyToTimesToValues.put(key, timesToValues);
        }
    }
    
    public String get(String key, int timestamp) {
        if (keyToTimesToValues.containsKey(key)) {
            TreeMap<Integer, String> timesToValues = keyToTimesToValues.get(key);
            if (timesToValues.containsKey(timestamp)) {
                return timesToValues.get(timestamp);
            } else {
                Integer earlierTimestamp = timesToValues.floorKey(timestamp);
                if (earlierTimestamp != null) {
                    return timesToValues.get(earlierTimestamp);
                } else {
                    return "";
                }
            }
        } else {
            return "";
        }
    }
}
