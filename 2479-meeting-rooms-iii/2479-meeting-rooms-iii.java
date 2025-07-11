class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->a[1] != b[1] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0]));
        PriorityQueue<Integer> vacantRooms = new PriorityQueue<>((a,b) -> a - b);
        for(int i=0;i<n;i++){
            vacantRooms.offer(i);
        }
        int[] rooms = new int[n];
        for(int index=0;index < meetings.length;index++){
            while(!pq.isEmpty() && pq.peek()[1] <= meetings[index][0]){
                vacantRooms.offer((int)pq.poll()[0]);
            }
            if(vacantRooms.isEmpty()){
                long[] top = pq.poll();
                int room = (int)(top[0]);
                long newEnd = top[1] + (meetings[index][1] - meetings[index][0]);
                pq.offer(new long[]{top[0],newEnd});
                rooms[room]++;
            }else{
                int room = vacantRooms.poll();
                pq.offer(new long[]{room,meetings[index][1]});
                rooms[room]++;
            }
        }

        int ans = -1;
        int val = -1;
        for(int i=0;i<n;i++){
            if(rooms[i] > val){
                val = rooms[i];
                ans = i;
            }
            // System.out.print(rooms[i] + " " + ans);
        }
        // System.out.println();
        return ans;
    }
}