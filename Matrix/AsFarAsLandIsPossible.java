class Solution {
    public int maxDistance(int[][] grid) {
        if(grid.length==0)
            return -1;

        int[][] visited = new int[grid.length][grid.length];

        for(int[] a :visited)
            Arrays.fill(a,-1);

        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                if(grid[i][j]==1){
                    visited[i][j] = 0;
                    q.offer(new int[]{i,j});
                }
            }
        }

        int[] dirX = {0,0,1,-1};
        int[] dirY = {1,-1,0,0};

        int max = -1;
        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                int[] front = q.poll();
                int row = front[0];
                int col = front[1];

                for(int i =0;i<4;i++){
                    int newR = row + dirX[i];
                    int newC = col + dirY[i];

                    if(newR>=0 && newR<grid.length && newC>=0 && newC<grid.length && visited[newR][newC]==-1){
                        q.offer(new int[]{newR,newC});
                        visited[newR][newC] = visited[row][col] + 1;
                        max = Math.max(visited[newR][newC],max);
                    }
                }
            }
        }
        return max;


    }
}