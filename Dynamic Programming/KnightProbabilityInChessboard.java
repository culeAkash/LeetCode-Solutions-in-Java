class Solution {

    int[] moveX = {1,1,2,2,-1,-2,-2,-1};
    int[] moveY = {2,-2,1,-1,-2,-1,1,2};


    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[n][n][k+1];

        for(double[][] a : dp){
            for(double[] b :a){
                Arrays.fill(b,-1);
            }
        }

        double success  = helper(row,column,n,k,dp);

        return success/Math.pow(8,k);
    }

    public double helper(int row,int col,int n,int steps,double[][][] dp){
        if(row<0 || row>=n || col < 0 || col >= n){
            return 0;
        }
        else if(steps==0){
           return 1;
        }

        if(dp[row][col][steps]!=-1)
            return dp[row][col][steps];

        double ans = 0;

        for(int i=0;i<8;i++){
            ans += helper(row+moveX[i],col+moveY[i],n,steps-1,dp);
        }

        return dp[row][col][steps] = ans;
    }
}