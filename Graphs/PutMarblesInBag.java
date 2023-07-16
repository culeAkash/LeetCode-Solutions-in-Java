class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        long[] sums = new long[n-1];
        for(int i=1;i<weights.length;i++){
            sums[i-1] = weights[i-1 ] + weights[i];
        }
        Arrays.sort(sums);
        long max = 0;
        long min = 0;
        int sumLength = n-1;
        for(int i=0;i<k-1;i++){
            min += sums[i];
            max += sums[sumLength - i -1];
        }

        return max-min;
    }
}