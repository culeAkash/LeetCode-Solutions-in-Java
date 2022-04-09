public class Solution {
    
    
    public static int findWays(int arr[],int target){
        int[][] dp= new int[arr.length][target+1];
        int n= arr.length;
        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }
        if(arr[0]<=target)
            dp[0][arr[0]]=1;
        
        for(int i=1;i<n;i++){
            for(int j=1;j<=target;j++){
                int take=0;
                if(arr[i]<=j)
                    take= dp[i-1][j-arr[i]];
                int notTake= dp[i-1][j];
                dp[i][j]= take + notTake;
            }
        }
        return dp[n-1][target];
    }
    
    
    public static int findWaysMemoized(int num[], int tar) {
        int[][] dp= new int[num.length][tar+1];
        for(int i=0;i<num.length;i++){
            for(int j=0;j<=tar;j++){
                dp[i][j]=-1;
            }
        }
        return helper(num.length-1,num,tar,dp);
    }
    
    public static int helper(int i,int[] arr,int t,int[][] dp){
        if(t==0)
            return 1;
        if(i==0){
            return arr[i]==t?1:0;
        }
        if(dp[i][t]!=-1)
            return dp[i][t];
        int take=0;
        if(arr[i]<=t){
            take = helper(i-1,arr,t-arr[i],dp);
        }
        int notTake = helper(i-1,arr,t,dp);
        
        dp[i][t] = take+notTake;
        return dp[i][t];
    }
}