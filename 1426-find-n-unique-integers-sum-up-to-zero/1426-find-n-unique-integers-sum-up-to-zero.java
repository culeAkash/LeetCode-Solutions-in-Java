class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        
        int index = 0;
        if((n&1)==1){
            res[index++] = 0;
        }
        int run = 1;
        while(index < n){
            res[index++] = run;
            res[index++] = -1 * run;
            run++;
        }
        return res;
    }
}