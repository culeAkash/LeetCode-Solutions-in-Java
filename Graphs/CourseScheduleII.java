class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //if there is a cycle in the directed graph then its not possible to complete all courses as directed

        boolean[] visited = new boolean[numCourses];
        boolean[] dfsVis = new boolean[numCourses];

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<Integer>());

        for(int[] pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }

        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(dfs(stack,adj,i,visited,dfsVis))
                    return new int[0];
            }
        }

        int[] res = new int[numCourses];
        int index = 0;
        while(index<numCourses){
            res[index++] = stack.pop();
        }

        return res;
    }

    boolean dfs(Stack<Integer> stack,List<List<Integer>> adj,int node,boolean[] visited,boolean[] dfs){
        visited[node] = true;
        dfs[node] = true;

        for(int it : adj.get(node)){
            if(!visited[it]){
                if(dfs(stack,adj,it,visited,dfs))
                    return true;
            }
            else if(dfs[it])
                return true;
        }
        dfs[node] = false;
        stack.push(node);
        return false;
    }
}