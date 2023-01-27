class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;

        int[] dist1 = new int[n];
        int[] dist2 = new int[n];

        Arrays.fill(dist1,Integer.MAX_VALUE);
        Arrays.fill(dist2,Integer.MAX_VALUE);

        bfs(node1,edges,dist1);
        bfs(node2,edges,dist2);

        int index = -1;
        int distance = Integer.MAX_VALUE;

        for(int i=0;i<dist1.length;i++){
            if(distance > Math.max(dist1[i],dist2[i])){
                index = i;
                distance = Math.max(dist1[i],dist2[i]);
            }
        }
        return index;

    }

    public void bfs(int node,int[] edges,int[] dist){
        Queue<Integer> q = new LinkedList<>();

        boolean[] visited = new boolean[edges.length];

        int distance = 0;

        q.offer(node);
        visited[node] = true;

        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                int front = q.poll();
                dist[front] = distance;
                int neighbor = edges[front];
                if(neighbor!=-1 && !visited[neighbor]){
                    visited[front] = true;
                    q.offer(neighbor);
                }
            }
            distance++;
        }
    }
}