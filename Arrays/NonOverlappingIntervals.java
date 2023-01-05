class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //Sort the intervals in ascending order of the starting time
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        int left = 0;
        int right = left + 1;

        int count = 0;

        while(right<intervals.length){
            if(intervals[left][1]<=intervals[right][0]){
                //No overlap conidtion, so just move forward
                left = right;
                right += 1;
            }
            else if(intervals[left][1]<=intervals[right][1]){
                //Overlap 1 => Not complete overlap just part of intervals overlapping,remove one of the interval
                count++;
                right++;
            }
            else if(intervals[left][1]>intervals[right][1]){
                //Overlap 2 => interval 2 is within the interval 1
                count++;
                left = right;
                right++;
            }
        }
        return count;
    }
}