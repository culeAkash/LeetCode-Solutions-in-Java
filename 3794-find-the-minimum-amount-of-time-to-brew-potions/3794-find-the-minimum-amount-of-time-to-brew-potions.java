class Solution {
    public long minTime(int[] skill, int[] mana) {
        int N = skill.length;

        int M = mana.length;

        long[] dp = new long[N+1];
        dp[0] = 0;
        for(int i=1;i<=N;i++)
            dp[i] = dp[i-1] + skill[i-1]*mana[0];

        for(int m=1;m<M;m++){
            long start = dp[1], end = dp[N];
            long startPoint = helper(start,end,dp,mana[m],skill);
            dp[0] = startPoint;
            for(int i=1;i<=N;i++)
                dp[i] = dp[i-1] + (long)skill[i-1]* (long)mana[m];
        }

        return dp[N];
    }

    private long helper(long start,long end,long[] dp,int mana,int[] skill){
        while(start<=end){
            // System.out.println(start + " " + end);
            long mid = start + (end - start) / 2;
            long run = mid;
            int flag = 0;
            for(int i=1;i<skill.length+1;i++){
                // System.out.println(run + " " + dp[i]);
                if(run < dp[i]){
                    flag=1;
                    break;
                }
                run += (long)mana * (long)skill[i-1];
            }
            if(flag==1){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
            // System.out.println(start + " " + end);
        }
        // System.out.println(start);
        return start;
        
    }
}