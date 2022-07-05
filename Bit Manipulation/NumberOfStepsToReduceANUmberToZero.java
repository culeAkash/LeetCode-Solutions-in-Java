class Solution {
    public int numberOfSteps(int num) {
        int res = 0;
        while(num>1){
            res+= 1 + (num & 1);
            num = num>>1;
        }
        return res+num;
    }
}