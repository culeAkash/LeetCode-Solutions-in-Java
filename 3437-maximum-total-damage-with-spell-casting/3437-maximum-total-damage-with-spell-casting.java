class Solution {
    public long maximumTotalDamage(int[] power) {
        TreeMap<Integer,Long> tmpp = new TreeMap<>();

        for(int p : power){
            tmpp.put(p,tmpp.getOrDefault(p,0L)+(long)p);
        }

        List<long[]> list = new ArrayList<>();

        for(Map.Entry<Integer,Long> entry : tmpp.entrySet()){
            list.add(new long[]{(long)entry.getKey(),entry.getValue()});
        }
        long[] dp = new long[list.size()];
        Arrays.fill(dp,-1L);
        return helper(list,0,dp);
    }

    private long helper(List<long[]> list,int index,long[] dp){
        if(index >= list.size()) return 0L;

        if(dp[index]!=-1L)return dp[index];

        //noTake
        long noTake = helper(list,index+1,dp);

        // if take
        long take = 0;

        int j = index + 1;
        while(j < list.size() && (list.get(j)[0]<=list.get(index)[0]+2))j++;
        take = (long)list.get(index)[1] + helper(list,j,dp);

        return dp[index] = Math.max(take,noTake); 
    }
}

