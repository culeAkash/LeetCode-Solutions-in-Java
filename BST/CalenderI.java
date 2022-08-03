class MyCalendar {

    Set<Pair> calender;
    public MyCalendar() {
        calender = new HashSet<>();
    }
    
    public boolean book(int start, int end) {
        if(calender.size()==0){
            calender.add(new Pair(start,end));
            return true;
        }
        
        for(Pair event:calender){
            if(event.start<=start && start<event.end)
                return false;
            
            if(event.start>=start && event.start<end)
                return false;
        }
        calender.add(new Pair(start,end));
        return true;
    }
}
class Pair{
    int start;
    int end;
    
    public Pair(int i,int j){
        start = i;
        end = j;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */