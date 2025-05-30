class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        List<List<Integer>> graph = new ArrayList<>();

        int N = edges.length;
        int[] dist1 = new int[N];
        int[] dist2 = new int[N];

        Arrays.fill(dist1,Integer.MAX_VALUE);
        Arrays.fill(dist2,Integer.MAX_VALUE);

        for(int i=0;i<N;i++){
            graph.add(new ArrayList<>());
        }

        for(int node = 0;node < N;node++){
            if(edges[node]!=-1){
                graph.get(node).add(edges[node]);
            }
        }

        bfs(graph,dist1,node1);
        bfs(graph,dist2,node2);


        int mini = Integer.MAX_VALUE;
        int ans = -1;
        for(int i=0;i<N;i++){
            if(Math.max(dist1[i],dist2[i]) < mini){
                mini = Math.max(dist1[i],dist2[i]);
                ans = i;
            }
        }

        return ans;

        
    }

    void bfs(List<List<Integer>> graph,int[] dist,int node){
        Queue<Integer> q = new LinkedList<>();
        int distance = 0;
        q.offer(node);
        dist[node] = 0;

        int[] visited = new int[dist.length];
        visited[node] = 1;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int top = q.poll();
                dist[top] = distance;
                for(int it : graph.get(top)){
                    if(visited[it]==0){
                        visited[it] = 1;
                        q.offer(it);
                    }
                }
            }
            distance++;
        }
    }
}