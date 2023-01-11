class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<Integer>());

        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        boolean[] visited = new boolean[n];

        int total = 0;
        visited[0] = true;
        for(int it : adj.get(0))
        total += dfs(it,adj,hasApple,visited);
        return total;
    }

    public int dfs(int node,List<List<Integer>> adj,List<Boolean> apples,boolean[] visited){

        if(visited[node])
            return 0;

        int total = 0;
        visited[node] = true;

        for(int it : adj.get(node)){
             total += dfs(it,adj,apples,visited);
        }

        if(total > 0 || apples.get(node))
            total += 2;

        return total;


    }
}