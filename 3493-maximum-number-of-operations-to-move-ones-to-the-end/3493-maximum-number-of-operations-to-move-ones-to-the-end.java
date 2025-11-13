class Solution {
    public int maxOperations(String s) {
        int N = s.length();
        int ans = 0;
        int ones = 0;
        for(int index=0;index<N-1;index++){
            if(s.charAt(index)=='1'){
                ones++;
                if(s.charAt(index+1)=='0')
                    ans += ones;
            }
        }

        return ans;
    }
}