class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];

        for(int i=0;i<bookings.length;i++){
            int start = bookings[i][0];
            int end = bookings[i][1];
            int seats = bookings[i][2];
            res[start-1] += seats;
            if(end<n)
                res[end] -= seats; 
        }
        for(int i=1;i<n;i++){
            res[i] += res[i-1];
        }
        return res;
    }
}