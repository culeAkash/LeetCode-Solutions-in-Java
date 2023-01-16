class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        if(intervals.length==0){
            res.add(new int[]{newInterval[0],newInterval[1]});
            return res.toArray(new int[res.size()][2]);
        }

        int start = newInterval[0];
        int end = newInterval[1];

        for(int[] interval : intervals){
            if(start>interval[1]){
                res.add(new int[]{interval[0],interval[1]});
            }
            else if(end < interval[0]){
                res.add(new int[]{start,end});
                start = interval[0];
                end = interval[1];
            }
            else{
                if(start>=interval[0])
                    start = interval[0];
                if(end <= interval[1])
                    end = interval[1];
            }
        }

        res.add(new int[]{start,end});
        return res.toArray(new int[res.size()][2]);
    }