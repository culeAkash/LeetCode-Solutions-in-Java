class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<Integer>[] adj = new ArrayList[n];
        
        for(int i=0;i<n;i++)
            adj[i] = new ArrayList<Integer>();

        for(int[] edge : edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        int[] components = new int[1];
        helper(n,adj,values,k,0,-1,components);
        return components[0];
    }

    private int helper(int n,List<Integer>[] adj,int[] values,int k,int node,int parent,int[] components){
        int sum = 0;
        for(int it : adj[node]){
            if(it!=parent){
                int itSum = helper(n,adj,values,k,it,node,components);
                sum += itSum;
                sum = sum % k;
            }
        }

        sum = (sum + values[node]) % k;
        if(sum==0){
            components[0]++;
        }

        return sum;
    }
}