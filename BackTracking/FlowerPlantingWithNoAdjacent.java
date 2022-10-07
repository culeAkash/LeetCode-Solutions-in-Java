class Solution {
    public int[] gardenNoAdj(int n, int[][] G) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i=0;i<=n;i++){
            List<Integer> list = new ArrayList<>();
            graph.add(list);
        }
        
        for(int i=0;i<G.length;i++){
            graph.get(G[i][0]).add(G[i][1]);
            graph.get(G[i][1]).add(G[i][0]);
        }
        
        int[] res = new int[n];
        int[] color = new int[n+1];
        solve(res,graph,n,1,color);
        return res;
    }
    
    public boolean solve(int[] res,List<List<Integer>> graph,int n,int node,int[] color){
        if(n<node)
            return true;
        
        for(int i=1;i<=4;i++){
            if(isSafe(i,graph,color,node)){
                res[node-1] = i;
                color[node] = i;
                
                if(solve(res,graph,n,node+1,color))
                    return true;
                
                color[node] = 0;
                res[node-1] = 0;
            }
        }
        return false;
    }
    
    public  boolean isSafe(int col,List<List<Integer>> graph,int[] color,int node){
        for(int adj : graph.get(node)){
            if(color[adj]==col)
                return false;
        }
        return true;
    }
    
    
}