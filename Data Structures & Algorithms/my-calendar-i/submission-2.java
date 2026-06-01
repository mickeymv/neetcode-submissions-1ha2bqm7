class Event {
    int start;
    int end;

    public Event(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }
}

class MyCalendar {

    TreeSet<Event> events = new TreeSet<>(Comparator.comparingInt(Event::getStart));

    public MyCalendar() {
        
    }
    
    public boolean book(int startTime, int endTime) {
        Event event = new Event(startTime, endTime);

        Event previousStart = events.floor(event);
        Event nextStart = events.ceiling(event);

        if ((previousStart!=null && previousStart.end>startTime) ||
        (nextStart!=null && endTime>nextStart.start)) {
            return false;
        }

        events.add(event);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */