public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int rsbm = 0;
        int count =0; 
        while(n!=0){
            rsbm = (n & (-n));
            n = n ^ rsbm;
            count++;
        }
        return count;
        
    }
}