class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<n;i++)
            adjList.add(new ArrayList<>());

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        int visited[] = new int[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(visited[i] == 0){
                if(bfs(i,visited,adjList)){
                    count++;
                }
            }
        }
        return count;
    }

    private boolean bfs(int node,int[] visited,List<List<Integer>> adjList){
        visited[node] = 1;

        Queue<Integer> q = new LinkedList<>();

        int vertexCount = 0;
        int edgeCount = 0;

        q.offer(node);

        while(!q.isEmpty()){
            int top = q.poll();
            System.out.println(top);
            vertexCount++;

            for(int it: adjList.get(top)){
                edgeCount++;
                if(visited[it]==0){
                    System.out.println("Neighbor node: " + it);
                    q.offer(it);
                    visited[it] = 1;
                }
            }
        }
        System.out.println("Vertex Count: " + vertexCount + " Edge Count: " + edgeCount);
        return edgeCount == ((vertexCount)*(vertexCount-1));
    }

}