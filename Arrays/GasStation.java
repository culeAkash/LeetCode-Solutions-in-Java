class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int balance = 0;
        int shortage = 0;
        
        for(int i=0;i<gas.length;i++){
            balance += gas[i] - cost[i];
            
            if(balance<0){
                shortage += balance;
                start = i+1;
                balance = 0;
            }
        }
        
        if(balance+shortage>=0)
            return start;
        return -1;
    }
}