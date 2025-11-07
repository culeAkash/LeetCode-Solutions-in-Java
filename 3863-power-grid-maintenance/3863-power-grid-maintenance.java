class Solution {
    Map<Integer,TreeSet<Integer>> idToVertices;
    List<List<Integer>> adj;
    Map<Integer,Integer> vertexToId;

    private void dfs(int node,int id,int[] visited){
        visited[node] = 1;
        vertexToId.put(node,id);
        idToVertices.computeIfAbsent(id,k-> new TreeSet<>()).add(node);
        for(int it : adj.get(node)){
            if(visited[it]==0){
                dfs(it,id,visited);
            }
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        idToVertices = new HashMap<>();
        adj = new ArrayList<>();
        vertexToId = new HashMap<>();

        for(int i=0;i<=c;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] connection : connections){
            adj.get(connection[0]).add(connection[1]);
            adj.get(connection[1]).add(connection[0]);
        }

        int[] visited = new int[c+1];

        int id = 0;
        for(int i=0;i<=c;i++){
            if(visited[i]==0){
                dfs(i,id,visited);
                id++;
            }
        }

        List<Integer> ans = new ArrayList<>();

        for(int[] q : queries){
            int type = q[0];
            int node = q[1];
            int pqId = vertexToId.get(node);

            TreeSet<Integer> ts = idToVertices.get(pqId);

            if(type==1){
                if(ts.contains(node))ans.add(node);
                else if(ts.size() > 0) ans.add(ts.first());
                else ans.add(-1);
            }else{
                ts.remove(node);
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}