class Solution {
    int MOD = 1000000007;
    public int countPermutations(int[] complexity) {
        long ans = 1L;
        int min = complexity[0];
        for(int index = 1;index < complexity.length;index++){
            if(complexity[index] <= min) return 0;

            ans = (ans * 1L * index) % MOD;
        }

        return (int)ans;
    }
}