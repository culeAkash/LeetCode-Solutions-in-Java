class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[][] cells = new int[n*n + 1][2];

        int[] columns = new int[n];
        for(int i=0;i<n;i++)
            columns[i] = i;

        int label = 1;
        for(int row=n-1;row>=0;row--){
            for(int col : columns){
                cells[label][0] = row;
                cells[label][1] = col;
                label++;
            }
            Collections.reverse(Arrays.asList(columns)); 
        }

        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n*n + 1];
        Arrays.fill(dist,-1);
        q.add(1);
        dist[1] = 0;

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int next = curr + 1;next <= Math.min(n*n,curr+6);next++){
                int row = cells[next][0];
                int col = cells[next][1];

                int destination = board[row][col] != -1 ? board[row][col] : next;

                if(dist[destination]==-1){
                    dist[destination] = dist[curr] + 1;
                    q.add(destination);
                }
            }
        }

        return dist[n*n];
    }
}