import java.util.* ;
import java.io.*; 
public class Solution 
{
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj, int v, int e) 
    {
        //Topo sort using Kahn's Algorithm
        
        int[] indegree = new int[v];
        
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        
        for(int i=0;i<v;i++)
            edges.add(new ArrayList<Integer>());
        
        for(int i=0;i<e;i++){
            edges.get(adj.get(i).get(0)).add(adj.get(i).get(1));
        }
        
        for(int i=0;i<v;i++){
            for(int it : edges.get(i)){
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<v;i++){
            if(indegree[i]==0)
                q.offer(i);
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int top = q.poll();
            res.add(top);
            
            for(int it : edges.get(top)){
                if(--indegree[it] ==0)
                    q.offer(it);
            }
        }
        return res;
    }
}
