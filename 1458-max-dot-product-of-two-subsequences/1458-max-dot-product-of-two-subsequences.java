class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        for(int[] d : dp)Arrays.fill(d,Integer.MIN_VALUE);
        return helper(0,0,nums1,nums2,nums1.length,nums2.length,dp);
    }

    private int helper(int i,int j,int[] nums1,int[] nums2,int M,int N,int[][] dp){
        if(i>=M || j>=N)return Integer.MIN_VALUE/2;

        if(dp[i][j]!=Integer.MIN_VALUE)return dp[i][j];

        int take = nums1[i]*nums2[j] + Math.max(0,helper(i+1,j+1,nums1,nums2,M,N,dp));
        int noTake = Math.max(helper(i+1,j,nums1,nums2,M,N,dp),helper(i,j+1,nums1,nums2,M,N,dp));

        return dp[i][j] = Math.max(take,noTake);
    }
}