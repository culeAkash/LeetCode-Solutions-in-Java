class Solution {
    int MOD = 1000000007;
    public int countTrapezoids(int[][] points) {
        Map<Integer,Integer> mpp = new HashMap<>();

        for(int[] point : points){
            int x = point[0];
            int y = point[1];

            mpp.put(y,(mpp.getOrDefault(y,0)+1));
        }
        long ans = 0;
        long sum = 0;
        for(Map.Entry<Integer,Integer> entry : mpp.entrySet()){
            int value = entry.getValue();
            if(value > 1){
                long pairs = ((long) value * (value - 1))/2;
                ans = (ans + (pairs * sum))%MOD;
                sum = (sum + pairs) % MOD;
            }
        }
        return (int) ans;
    }
}