class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        boolean[] check = new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(graph,V,visited,pathVisited,check,i);
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            if(check[i])
                ans.add(i);
        }
        
        return ans;
    }

    boolean dfs(int[][] adj,int V,boolean[] visited,boolean[] pathVisited,boolean[] check,int node){
        visited[node] = true;
        pathVisited[node] = true;
        
        for(int it : adj[node]){
            if(!visited[it]){
                if(dfs(adj,V,visited,pathVisited,check,it))
                    return true;
            }
            else if(pathVisited[it]){
                return true;
            }
        }
        
        pathVisited[node] = false;
        check[node] = true;
        return false;
    }
}