import java.util.*;
public class Solution 
{
    public static Boolean isCyclic(int[][] edges, int v, int e)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        
        int[] indegree = new int[v];
        for(int i=0;i<v;i++){
            for(int it : adj.get(i))
                indegree[it]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<v;i++){
            if(indegree[i]==0)
                q.offer(i);
        }
        int count = 0;
        while(!q.isEmpty()){
            count++;
            int top = q.poll();
            
            for(int it : adj.get(top)){
                if(--indegree[it]==0)
                    q.offer(it);
            }
        }
        return count!=v;
        
	}
}