class Solution {
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int nodes = 0;
        long ans = 0;

        boolean[] visited = new boolean[n];

        for(int i=0;i<n;i++){
            if(!visited[i]){
                int count = bfs(adj,n,visited,i);
                ans += (long)nodes*count;
                nodes += count;
            }
        }

        return ans;

    }

    public int bfs(List<List<Integer>> adj,int n,boolean[] visited,int node){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;

        int count = 1;
        while(!q.isEmpty()){
            int top = q.poll();
            for(int it : adj.get(top)){
                if(!visited[it]){
                    visited[it] = true;
                    count++;
                    q.offer(it);
                }
            }
        }
        return count;
    }
}