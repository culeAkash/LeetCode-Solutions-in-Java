class Solution {

    private static final int MOD = 1000000007;

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        Queue<int[]> delayQueue = new LinkedList<>();
        Queue<int[]> forgetQueue = new LinkedList<>();
        int knowCnt = 1;
        int shareCnt = 0;
        delayQueue.offer(new int[]{1,1});
        for(int i=2;i<=n;i++){
            if(!delayQueue.isEmpty() && delayQueue.peek()[0] == i - delay){
                int[] first = delayQueue.poll();
                knowCnt = (knowCnt - first[1] + MOD) % MOD;
                shareCnt = (shareCnt + first[1]) % MOD;
                forgetQueue.offer(first);
            }
            if(!forgetQueue.isEmpty() && forgetQueue.peek()[0] == i - forget){
                int[] first = forgetQueue.poll();
                shareCnt = (shareCnt - first[1] + MOD) % MOD;
            }

            if(!forgetQueue.isEmpty()){
                    knowCnt = (knowCnt + shareCnt) % MOD;
                    delayQueue.offer(new int[]{i,shareCnt});
            }
        }
        return (shareCnt + knowCnt) % MOD;
    }
}