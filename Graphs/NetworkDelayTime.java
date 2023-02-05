class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i=1;i<=n+1;i++)
            adj.add(new ArrayList<>());

        for(int i=0;i<times.length;i++){
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];

            adj.get(u).add(new int[]{v,w});
            // adj.get(v).add(new int[]{u,w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comp());

        int[] distance = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[k-1] = 0;

        pq.offer(new int[]{0,k});

        while(!pq.isEmpty()){
            int[] front = pq.poll();

            for(int[] pair : adj.get(front[1])){
                int node = pair[0];
                int weight = pair[1];

                int dist = front[0] + weight;

                if(dist<distance[node-1]){
                    pq.offer(new int[]{dist,node});
                    distance[node-1] = dist;
                }
            }
        }

        int max = -1;
        for(int dist : distance){
            if(dist==Integer.MAX_VALUE)
                return -1;
            max = Math.max(max,dist);
        }

        return max;
    }
}

class Comp implements Comparator<int[]>{
    public int compare(int[] a,int[] b){
        if(a[0]==b[0])
            return a[1] - b[1];
        return a[0] - b[0];
    }
}