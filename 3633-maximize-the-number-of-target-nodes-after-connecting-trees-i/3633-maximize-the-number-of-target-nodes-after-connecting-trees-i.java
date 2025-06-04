class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int[] count1 = createGraph(edges1,k);
        int[] count2 = createGraph(edges2,k-1);

        int maxTarget = 0;

        for(int count : count2){
            maxTarget = Math.max(maxTarget,count);
        }
        int N = edges1.length + 1;
        int[] res = new int[N];

        for(int i=0;i<N;i++){
            // System.out.println(count1[i] + " " + maxTarget);
            res[i] = count1[i] + maxTarget;
        }

        return res;
    }


    int[] createGraph(int[][] edges,int k){
        int N = edges.length + 1;
        int[] count = new int[N];
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<N;i++)
            graph.add(new ArrayList<>());

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        for(int i=0;i<N;i++){
            count[i] = dfs(i,-1,graph,k);
        }
        return count;
    }

    int dfs(int node,int parent,List<List<Integer>> graph,int k){
        if(k<0)return 0;
        int res = 1;
        for(int child : graph.get(node)){
            if(child!=parent){
                res += dfs(child,node,graph,k-1);
            }
        }
        return res;
    }
}