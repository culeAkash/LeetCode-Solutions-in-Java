class Solution {
    public long maxScore(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] visited = new int[n];

        List<int[]> cyclic = new ArrayList<>();
        List<int[]> nonCyclic = new ArrayList<>();

        for(int node = 0;node < n;node++){
            int[] count = new int[1];
            count[0] = 0;
            if(visited[node]==1)continue;
            if(dfs(count,visited,graph,node,-1)){
                cyclic.add(new int[]{count[0],node});
            }else{
                nonCyclic.add(new int[]{count[0],node});
            }
        }

        Collections.sort(cyclic,(a,b)->b[0] - a[0]);
        Collections.sort(nonCyclic,(a,b)->b[0]-a[0]);


        int v = n;
        long ans = 0;

        for(int[] pair : cyclic){
            int nodeCount = pair[0];

            long[] vals = new long[nodeCount];

            long nodeVal = v - nodeCount + 1;
            int j = 0;
            for(j=0;j<(nodeCount)/2;j++){
                vals[j] = nodeVal++;
                vals[nodeCount-j-1] = nodeVal++;
            }

            if((nodeCount&1)==1){
                vals[j] = nodeVal;
            }

            for(int k=1;k<nodeCount;k++){
                ans += vals[k] * vals[k-1];
            }

            ans += vals[0] * vals[nodeCount-1];

            // for(int a=0;a<nodeCount;a++)
            //     System.out.print(vals[a] + " ");
            // System.out.println();
            v -= nodeCount;
        }


        for(int[] pair : nonCyclic){
            int nodeCount = pair[0];

            long[] vals = new long[nodeCount];

            long nodeVal = v - nodeCount + 1;
            int j = 0;
            for(j=0;j<(nodeCount)/2;j++){
                vals[j] = nodeVal++;
                vals[nodeCount-j-1] = nodeVal++;
            }

            if((nodeCount&1)==1){
                vals[j] = nodeVal;
            }

            for(int k=1;k<nodeCount;k++){
                ans += vals[k] * vals[k-1];
            }

            // for(int a=0;a<nodeCount;a++)
            //     System.out.print(vals[a] + " ");
            // System.out.println();
            v -= nodeCount;
        }

        return ans;
    }

    boolean dfs(int[] count,int[] visited,List<List<Integer>> graph,int node,int parent){
        visited[node] = 1;
        count[0]++;

        for(int it : graph.get(node)){
            if(visited[it]!=1){
                if(dfs(count,visited,graph,it,node))return true;
            }else if(it!=parent)return true;
        }
        return false;
    }
}