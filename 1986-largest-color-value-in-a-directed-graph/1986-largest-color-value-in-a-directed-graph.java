class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int N = colors.length();
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[N];

        for(int i=0;i<N;i++)
            graph.add(new ArrayList<>());

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            indegree[v]++;
        }

        Map<Integer,int[]> dp = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<N;i++){
            dp.put(i,new int[26]);
            if(indegree[i]==0)
                q.offer(i);
            int color = colors.charAt(i) - 'a';
            dp.get(i)[color] = 1;
        }


        int visited = 0;
        int maxValue = 1;


        while(!q.isEmpty()){
            int node = q.poll();
            visited++;

            for(int it : graph.get(node)){
                for(int c=0;c<26;c++){
                    int inc = colors.charAt(it) -'a' == c ? 1 : 0;
                    dp.get(it)[c] = Math.max(dp.get(it)[c],dp.get(node)[c] + inc);
                    maxValue = Math.max(dp.get(it)[c],maxValue);
                }

                if(--indegree[it]==0){
                    q.offer(it);
                }
            }

            
        }

        return visited==N ? maxValue : -1;
    }
}