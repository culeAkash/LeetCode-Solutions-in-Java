class Solution {
    List<List<int[]>> graph;
    Map<String,Integer> dp;
    public int maxWeight(int n, int[][] edges, int k, int t) {
        if(k==0)
            return 0;
        graph = new ArrayList<>();
        dp = new HashMap<>();

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            graph.get(u).add(new int[]{v,wt});
        }

        int ans = -1;

        for(int i=0;i<n;i++){
            ans = Math.max(ans,dfs(i,k,t));
        }

        return ans;

    }

    int dfs(int node,int remSteps,int remTime){
        if(remSteps==0){
            if(remTime > 0){
                return 0;
            }
            return Integer.MIN_VALUE;
        }

        if(remTime <= 0) return Integer.MIN_VALUE;

        String key = node + "*" + remSteps + "*" + remTime;

        if(dp.containsKey(key))return dp.get(key);

        int finalWt = Integer.MIN_VALUE;
        for(int[] adj : graph.get(node)){
            int adjNode = adj[0];
            int wt = adj[1];

            finalWt = Math.max(finalWt,wt + dfs(adjNode,remSteps-1,remTime-wt));
        }

        dp.put(key,finalWt);
        return finalWt;
    }
}