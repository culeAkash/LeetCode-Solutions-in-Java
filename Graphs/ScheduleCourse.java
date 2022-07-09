class Solution {
    public boolean canFinish(int numCourses, int[][] pre) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            adjList.add(new ArrayList<>());
        
        for(int i=0;i<pre.length;i++){
            adjList.get(pre[i][1]).add(pre[i][0]);
        }
        
        boolean[] visited = new boolean[numCourses];
        boolean[] dfsVisited = new boolean[numCourses];
        
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(dfsCycleCheck(adjList,visited,dfsVisited,i))
                    return false;
            }
        }
        
        return true;
    }
    
    public boolean dfsCycleCheck(ArrayList<ArrayList<Integer>> adjList,boolean[] visited,boolean[]dfsVisited,int i){
        visited[i] = true;
        dfsVisited[i] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,-1));
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            for(int j:adjList.get(p.elem)){
                if(!visited[j]){
                    if(dfsCycleCheck(adjList,visited,dfsVisited,j))
                        return true;
                }
                else if(dfsVisited[j])
                    return true;
            }
        }
        dfsVisited[i] = false;
        return false;
    }
}

class Pair{
    int elem;
    int par;
    
    public Pair(int e,int p){
        elem = e;
        par =p;
    }
}