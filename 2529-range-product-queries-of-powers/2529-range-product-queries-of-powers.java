class Solution {
    private static int MOD = 1000000007;
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> prods = new ArrayList<>();
        int runningMul = 1; 
        while(n > 0){
            // find if current last bit is set or not
            if((n&1)==1){
                prods.add(runningMul);
            }
            // System.out.println(n + " " + runningMul);
            n = n >> 1;
            runningMul = runningMul << 1;
        }
        int m = prods.size();
        int[][] results = new int[m][m];
        for(int i=0;i<m;i++){
            long cur = 1;
            for(int j=i;j<m;j++){
                cur = (cur * prods.get(j)) % MOD;
                results[i][j] = (int)cur;
            }
        }

        int[] ans = new int[queries.length];

        for(int i=0;i<ans.length;i++){
            ans[i] = results[queries[i][0]][queries[i][1]];
            
        }

        return ans;
    }
}