class Solution {
    public int maxEvents(int[][] events) {
        PriorityQueue<Integer> endDays = new PriorityQueue<>();

        Arrays.sort(events,(a,b)->a[0] - b[0]);

        int index = 0;
        int n = events.length;
        int res = 0;
        for(int day=1;day<=100000;day++){
            while(!endDays.isEmpty() && endDays.peek() < day)
                endDays.poll();

            while(index < n && day == events[index][0]){
                endDays.offer(events[index][1]);
                index++;
            }

            if(!endDays.isEmpty()){
                endDays.poll();
                res++;
            }
        }
        return res;
    }
}