class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<K;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<N-1;i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            
            int length = Math.min(s1.length(),s2.length());
            
            for(int j=0;j<length;j++){
                if(s1.charAt(j)!=s2.charAt(j)){
                    adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    break;
                }
            }
        }
        
        ArrayList<Integer> topo = topoSort(K,adj);
        
        String res = "";
        for(int it : topo)
            res += (char)(it+'a');
            
        return res;
        
    }
    
     ArrayList<Integer> topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] indegree = new int[V];
        
        
        //find indegree of all nodes
        for(int i=0;i<V;i++){
            for(int it:adj.get(i))
                indegree[it]+=1;
        }
        
        ArrayList<Integer> topo = getTopoSort(adj,indegree);
        return topo;
    }
    
     ArrayList<Integer> getTopoSort(ArrayList<ArrayList<Integer>> adj,int[] indegree){
        ArrayList<Integer> topo = new ArrayList<Integer>();
        
        Queue<Integer> pendingNodes = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0)
                pendingNodes.add(i);
        }
        while(!pendingNodes.isEmpty()){
            int head = pendingNodes.poll();
            topo.add(head);
            for(int it:adj.get(head)){
                indegree[it]--;
                if(indegree[it]==0)
                    pendingNodes.add(it);
            }
        }
        return topo;
    }
}