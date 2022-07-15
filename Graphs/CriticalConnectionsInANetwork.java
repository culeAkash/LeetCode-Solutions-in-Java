class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] visited = new int[n];
        int[] time = new int[n];
        int[] low = new int[n];
        
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int i=0;i<connections.size();i++){
            adjList.get(connections.get(i).get(0)).add(connections.get(i).get(1));
            adjList.get(connections.get(i).get(1)).add(connections.get(i).get(0));
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        int timer = 0;
        for(int i=0;i<n;i++){
            if(visited[i]==0)
                dfs(i,-1,visited,time,low,adjList,timer,ans);
        }
        return ans;
    }
    
    public void dfs(int node,int par,int[] vis,int[] time,int[] low,List<List<Integer>> adj,int timer,List<List<Integer>> ans){
        vis[node] = 1;
        
        time[node] = low[node] = timer++;
        
        for(int it:adj.get(node)){
            if(it==par)
                continue;
            
            if(vis[it]==0){
                dfs(it,node,vis,time,low,adj,timer,ans);
                low[node] = Math.min(low[node],low[it]);
                
                if(time[node]<low[it]){
                    List<Integer> sm = new ArrayList<>();
                    sm.add(node);
                    sm.add(it);
                    ans.add(sm);
                }
            }
            else{
                low[node] = Math.min(low[node],time[it]);
            }
        }
    }
}