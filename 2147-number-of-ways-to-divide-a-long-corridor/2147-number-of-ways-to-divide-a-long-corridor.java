class Solution {
    int MOD = 1000000007;
    public int numberOfWays(String s) {
        int seats = 0;
        int plants = 0;
        long ans = 1L;

        int index = 0;
        int N = s.length();

        while(index < N){
            if(s.charAt(index)=='S'){
                seats++;
            }
            index++;
            if(seats > 0 && ((seats&1)==0)){
                while(index < N && s.charAt(index)!='S'){
                    plants++;
                    index++;
                }

                if(index < N){
                    ans = (1L * ans * (plants+1))%MOD;
                }
            }
            plants = 0;
        }

        if((seats&1)!=0 || (seats<2))return 0;
        return (int)ans;

    }
}