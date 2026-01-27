class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int index=0;index<n;index++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new int[]{v,wt});
            adj.get(v).add(new int[]{u,wt*2});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1] - b[1]);

        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);

        pq.offer(new int[]{0,0});
        dist[0] = 0;

        while(!pq.isEmpty()){
            int[] top = pq.poll();

            int node = top[0];
            int cost = top[1];

            if(node==n-1)return cost;

            if(visited[node])continue;
            visited[node] = true;

            for(int[] it : adj.get(node)){
                if(cost + it[1] < dist[it[0]]){
                    dist[it[0]] = it[1] + cost;
                    pq.offer(new int[]{it[0],it[1] + cost});
                }
            }
        }

        return -1;
    }
}