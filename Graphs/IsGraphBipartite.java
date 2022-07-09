class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors,-1);
        
        for(int i=0;i<graph.length;i++){
            if(colors[i]==-1){
                if(!checkIfBipartite(graph,colors,i))
                    return false;
            }
        }
        return true;
    }
    
    public boolean checkIfBipartite(int[][] graph,int[] colors,int i){
        colors[i] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        
        while(!q.isEmpty()){
            int t = q.poll();
        for(int n:graph[t]){
            if(colors[n]==-1){
                colors[n] = 1- colors[t];
                q.add(n);
            }
            else{
                if(colors[n] == colors[t])
                    return false;
            }
        }
        }
        return true;
    }
}