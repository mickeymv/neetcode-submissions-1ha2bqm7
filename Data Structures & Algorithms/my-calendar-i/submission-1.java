class Event {
    int startTime;
    int endTime;

    public Event(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

class MyCalendar {

    List<Event> events = new ArrayList<>();

    public MyCalendar() {
        
    }
    
    public boolean book(int startTime, int endTime) {
        for (Event event : events) {
            if (event.startTime<endTime && startTime<event.endTime) {
                //there is an overlap 
                return false;
            }
        }   

        events.add(new Event(startTime, endTime));
        return true; 
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */