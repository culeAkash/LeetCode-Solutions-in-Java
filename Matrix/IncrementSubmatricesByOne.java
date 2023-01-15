class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] res = new int[n][n];
        
        for(int[] q : queries){
            int x1 = q[0];
            int y1 = q[1];
            int x2 = q[2];
            int y2 = q[3];
            
            for(int i=x1;i<=x2;i++){
                for(int j=y1;j<=y2;j++){
                    res[i][j]++;
                }
            }
        }
        return res;
    }
}