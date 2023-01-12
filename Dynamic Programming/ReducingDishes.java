class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);

        int[][] memo = new int[satisfaction.length][satisfaction.length+1];
        for(int[] m :memo)
            Arrays.fill(m,-1);
        return helper(satisfaction,0,1,memo);
    }

    int helper(int[] s,int index,int time,int[][] memo){
        if(index==s.length)
            return 0;

        if(memo[index][time]!=-1)
            return memo[index][time];

        int pick = (s[index] * time) + helper(s,index+1,time+1,memo);
        int notPick = helper(s,index+1,time,memo);

        return memo[index][time] = Math.max(pick,notPick);

    }
}