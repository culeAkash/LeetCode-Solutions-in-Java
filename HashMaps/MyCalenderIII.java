class MyCalendarThree {

    TreeMap<Integer,Integer> tm ;
    public MyCalendarThree() {
        tm = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        tm.putIfAbsent(start,0);
        tm.putIfAbsent(end,0);
        
        tm.put(start,tm.get(start)+1);
        tm.put(end,tm.get(end)-1);
        
        return kBook(tm);
        
    }
    
    private int kBook(TreeMap<Integer,Integer> tm){
        int count = 0;
        int ans = 0;
        
        for(Integer ls: tm.values()){
            count += ls;
            ans = Math.max(ans,count);
        }
        
        return ans;
        
    }
}