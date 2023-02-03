class SummaryRanges {
    Set<Integer> ranges;

    public SummaryRanges() {
        ranges = new TreeSet<Integer>();
    }
    
    public void addNum(int value) {
        ranges.add(value);
    }
    
    public int[][] getIntervals() {
        if(ranges.size()==0){
            return new int[0][2];
        }

        List<int[]> intervals = new ArrayList<>();
        int start = -1;
        int end = -1;

        for(int num : ranges){
            if(start<0){
                start = end = num;
            }
            else if(end+1==num){
                end = num;
            }
            else{
                intervals.add(new int[]{start,end});
                start = end = num;
            }
        }
        intervals.add(new int[]{start,end});
        return intervals.toArray(new int[0][]);

        
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */