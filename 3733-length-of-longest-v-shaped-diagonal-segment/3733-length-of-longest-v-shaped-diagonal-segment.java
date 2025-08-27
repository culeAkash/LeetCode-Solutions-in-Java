class Solution {
    Map<Integer,int[]> map = new HashMap<>(){{
        put(0,new int[]{1,1});
        put(1,new int[]{1,-1});
        put(2,new int[]{-1,-1});
        put(3,new int[]{-1,1});
    }};

    public int lenOfVDiagonal(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        int[][][][] dp = new int[m][n][4][2];

        for(int[][][] d : dp){
            for(int[][] p : d){
                for(int[] a : p){
                    Arrays.fill(a,-1);
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    for(int d=0;d<4;d++){
                        res = Math.max(res,helper(i,j,m,n,d,0,grid,2,dp) + 1);
                    }
                }
            }
        }

        return res;
    }

    private int helper(int row,int col,int m,int n,int direction,int hasTakenTurn,int[][] grid,int nextMove,int[][][][] dp){
        int nextRow = row + map.get(direction)[0];
        int nextCol = col + map.get(direction)[1];

        // check if going out of bounds or not a valid cell
        if(nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || grid[nextRow][nextCol]!=nextMove)
        return 0;

        if(dp[nextRow][nextCol][direction][hasTakenTurn]!=-1){
            return dp[nextRow][nextCol][direction][hasTakenTurn];
        }

        int tempRes = 0;

        // if turn is already taken or we want to move forward even if turn is not taken
        tempRes = Math.max(tempRes,helper(nextRow,nextCol,m,n,direction,hasTakenTurn,grid,2 - nextMove,dp) + 1);

        // take turn if already not taken
        if(hasTakenTurn == 0){
            tempRes = Math.max(tempRes,helper(nextRow,nextCol,m,n,(direction+1)%4,1,grid,2-  nextMove,dp) + 1);
        }

        return dp[nextRow][nextCol][direction][hasTakenTurn] = tempRes;
    }
}