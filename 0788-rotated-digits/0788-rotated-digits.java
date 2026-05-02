class Solution {
    public int rotatedDigits(int n) {
        int[] dp = new int[n+1];
        int count = 0;

        for(int num=0;num<=n;num++){
            if(num<10){
                if(num==1 || num==0 || num==8)
                    dp[num] = 1;
                else if(num==5 || num==2 || num==6 || num==9){
                    dp[num] = 2;
                    count++;
                }
                else
                    dp[num] = 0;
                continue;
            }

            int a = num % 10;
            int b = num / 10;

            if(dp[a]==1 && dp[b]==1)
                dp[num] = 1;
            else if(dp[a]>=1 && dp[b]>=1){
                dp[num] = 2;
                count++;
            }
            else
                dp[num] = 0;
        }
        return count;
    }
}