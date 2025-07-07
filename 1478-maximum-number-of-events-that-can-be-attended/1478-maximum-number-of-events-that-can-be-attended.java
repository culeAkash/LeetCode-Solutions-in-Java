class Solution {
    public int maxEvents(int[][] events) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        int index = 0;
        int N = events.length;
        int res = 0;

        for(int days=1;days<=100000;days++){
            while(!pq.isEmpty() && days > pq.peek()){
                // remove events already closed and can't be completed
                pq.poll();
            }

            while(index < N && events[index][0]==days){
                // insert end day when start day is reached
                pq.offer(events[index][1]);
                index++;
            }

            if(!pq.isEmpty()){
                // complete a event for the day
                res++;
                pq.poll();
            }
        }

        return res;
    }
}