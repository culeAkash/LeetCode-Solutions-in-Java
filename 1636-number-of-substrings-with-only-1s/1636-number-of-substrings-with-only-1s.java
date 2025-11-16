class Solution {
    int MOD = 1000000007;
    public int numSub(String s) {
        int index = 0;
        int ans = 0;

        while(index < s.length() && s.charAt(index)=='0')index++;

        int l = index, r= index;

        while(r < s.length()){
            if(s.charAt(r)=='1'){
                ans = (ans + ((r - l + 1) % MOD)) % MOD;
            }
            r++;
            if(s.charAt(r-1)=='0') l = r;
        }

        return ans % MOD;
    }
}