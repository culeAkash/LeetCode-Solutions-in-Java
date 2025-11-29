class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<Integer>[] adj = new ArrayList[n];
        
        for(int i=0;i<n;i++)
            adj[i] = new ArrayList<Integer>();

        for(int[] edge : edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        return helper(n,adj,values,k,0,-1).count;

    }

    private Pair helper(int n,List<Integer>[] adj,int[] values,int k,int node,int parent){
        int sum = 0;
        int count = 0;
        for(int it : adj[node]){
            if(it!=parent){
                Pair itPair = helper(n,adj,values,k,it,node);

                int itSum = itPair.sum;
                int itCount = itPair.count;

                sum = (sum +itSum) % k;
                count += itCount;

            }
        }
        sum = (sum + values[node]) % k;
        if(sum==0){
            count += 1;
        }        

        return new Pair(sum,count);
    }
}

class Pair{
    int sum;
    int count;

    public Pair(int sum,int count){
        this.sum = sum;
        this.count = count;
    }
}