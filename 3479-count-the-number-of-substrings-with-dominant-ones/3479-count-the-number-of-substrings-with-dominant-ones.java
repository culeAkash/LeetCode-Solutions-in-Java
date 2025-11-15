class Solution {
    public int numberOfSubstrings(String s) {
        int N = s.length();

        int[] nextZero = new int[N];

        nextZero[N-1] = N;

        for(int i=N-2;i>=0;i--){
            if(s.charAt(i+1)=='0'){
                nextZero[i] = i+1;
            }else{
                nextZero[i] = nextZero[i+1];
            }
        }

        int res = 0;
        int l = 0;
        
        while(l < N){
            int zeros = s.charAt(l)=='0' ? 1 : 0;
            int r = l;
            while(r < N && zeros*zeros < N){
                int nextZ = nextZero[r];
                int ones = (nextZ - l) - zeros;
                if(zeros*zeros <= ones){
                    res += Math.min(nextZ - r,ones - zeros*zeros + 1);
                }
                r = nextZ;
                zeros++;
            }
            l++;
        }

        return res;
    }
}