class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int M = heights.length;
        int N = heights[0].length;

        boolean[][] pacific = new boolean[M][N];
        boolean[][] atlantic = new boolean[M][N];

        for(int i=0;i<M;i++){
            dfs(i,0,heights,M,N,pacific);
            dfs(i,N-1,heights,M,N,atlantic);
        }

        for(int j=0;j<N;j++){
            dfs(0,j,heights,M,N,pacific);
            dfs(M-1,j,heights,M,N,atlantic);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }

        return res;

    }

    private static int[] dirX = {1,-1,0,0};
    private static int[] dirY = {0,0,-1,1};

    private void dfs(int row,int col,int[][] heights,int M,int N,boolean[][] visited){
        visited[row][col] = true;

        for(int d=0;d<4;d++){
            int nextR = row + dirX[d];
            int nextC = col + dirY[d];

            if(nextR >=0 && nextR < M && nextC >=0 && nextC < N && !visited[nextR][nextC] && heights[nextR][nextC] >= heights[row][col]){
                dfs(nextR,nextC,heights,M,N,visited);
            }
        }
    }
}