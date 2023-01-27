class Solution {

    int ans = 0;
    int maxAns = Integer.MIN_VALUE;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        List<List<Integer>> adj = constructTree(edges);

        int[] parent = new int[edges.length + 1];
        int[] distance = new int[edges.length + 1];

        getPathFromRootToLeaf(parent,distance,0,0,0,adj);

        avoidBobPath(adj,distance,parent,amount,bob);

        
        dfsPath(adj,amount,0);

        return maxAns;

    }

    Set<Integer> visited = new HashSet<>();

    public void dfsPath(List<List<Integer>> adj,int[] amount,int curr){
        visited.add(curr);
        ans += amount[curr];
        int trav = 0;

        for(int it : adj.get(curr)){
            if(visited.contains(it))
                continue;

            trav = 1;
            dfsPath(adj,amount,it);
        }

        if(trav == 0)
            maxAns = Math.max(ans,maxAns);

        ans -= amount[curr];
    }

    public void avoidBobPath(List<List<Integer>> adj,int[] distance,int parent[],int[] amount,int curr){
        int dist = 0;
        while(curr!=0){
            if(dist < distance[curr])
                amount[curr] = 0;
            else if(dist == distance[curr])
                amount[curr] /= 2;
            
            curr = parent[curr];
            dist++;
        }
    }

    public void getPathFromRootToLeaf(int[] parent,int[] distance,int curr,int dist,int currParent,List<List<Integer>> adj){
        parent[curr] = currParent;
        distance[curr] = dist;

        for(int it : adj.get(curr)){
            if(it==parent[curr])
                continue;
            
            getPathFromRootToLeaf(parent,distance,it,dist+1,curr,adj);
        }
    }



    public List<List<Integer>> constructTree(int[][] edges){
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<=edges.length;i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        return adj;
    }
}