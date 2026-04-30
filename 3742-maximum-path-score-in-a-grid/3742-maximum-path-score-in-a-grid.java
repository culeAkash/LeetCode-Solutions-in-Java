class Solution {
    private final int MIN = -100001;
    public int maxPathScore(int[][] grid, int k) {
        int N = grid.length;
        int M = grid[0].length;
        int[][] next = new int[M+1][k+1];
        int[][] curr = new int[M+1][k+1];
        Arrays.fill(next[M],MIN);

        for(int row=N-1;row>=0;row--){
            for(int col=M-1;col>=0;col--){
                for(int c=0;c<=k;c++){
                    int cost = grid[row][col] == 0 ? 0 : 1; 
                    if(row==N-1 && col==M-1 && c - cost >= 0){
                        curr[col][c] = grid[row][col];
                        continue;
                    }
                    int right = MIN;
                    if(row+1<N && c-cost>=0){
                        right = grid[row][col] + next[col][c-cost];
                    }
                    int bottom = MIN;
                    if(col+1 < M && c-cost>=0){
                        bottom = grid[row][col] + curr[col+1][c-cost];
                    }

                    curr[col][c] = Math.max(bottom,right);
                }
            }
            for(int i=0;i<=M;i++){
                    next[i] = curr[i].clone();
            }
        }

        int res = MIN;

        for(int c=0;c<=k;c++){
            res = Math.max(next[0][c],res);
        }
    
        return  res < 0 ? -1 : res;
    }
}