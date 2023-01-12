class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] res = new int[n];
        

        dfs(adj,res,-1,0,labels);

        return res;
    }

    int[] dfs(List<List<Integer>> adj,int[] res,int parent,int node,String labels){
        
        int[] counts = new int[26];

        for(int it : adj.get(node)){
            if(it!=parent){
                int[] temp = dfs(adj,res,node,it,labels);

                for(int i=0;i<26;i++){
                    counts[i] += temp[i];
                }
            }
        }
        
        res[node] = (++counts[labels.charAt(node)-'a']);
        
        return counts;

    }
}