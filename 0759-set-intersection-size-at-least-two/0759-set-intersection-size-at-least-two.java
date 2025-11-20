class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]==b[1] ? b[0] - a[0] : a[1] - b[1]);

        int ans = 0;
        int p1=-1,p2=-1;

        for(int[] interval : intervals){
            int start = interval[0],end = interval[1];

            if(start > p2){
                p2 = interval[1];
                p1 = interval[1] - 1;
                ans +=2;
            }else if(start > p1){
                p1 = p2;
                p2 = interval[1];
                ans++;
            }
        }

        return ans;
    }
}