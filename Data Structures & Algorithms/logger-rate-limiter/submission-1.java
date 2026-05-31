class Logger {

    HashMap<String, Integer> logsToTimes = new HashMap<>();

    public Logger() {
        
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (logsToTimes.containsKey(message)) {
            int earlierTime = logsToTimes.get(message);
            if (timestamp >= (earlierTime+10)) {
                logsToTimes.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        } else {
            logsToTimes.put(message, timestamp);
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
