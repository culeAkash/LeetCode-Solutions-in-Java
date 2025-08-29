class Solution {
    public long flowerGame(int N, int M) {
        long n = (long) N;
        long m = (long) M;
        return ((n/2) * (((m&1)==0) ? m/2 : (m/2 + 1))) + ((m/2) * (((n&1)==0) ? n/2 : (n/2 + 1)));
    }
}