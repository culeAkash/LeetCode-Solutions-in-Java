class Solution {
    public long minOperations(int[][] queries) {
        long res = 0L;
        for(int[] query : queries){
            int l = query[0],r = query[1];
            long total = calculateSum(r) - calculateSum(l-1);
            res += (total + 1) / 2; 
        }
        return res;
    }

    long calculateSum(int num){
        int base = 1;
        int step = 1;
        long res = 0L;
        while(base <= num){
            long count = Math.min(num,base * 4 - 1) - base + 1;
            res += (count * step);
            step++;
            base *= 4;
        }
        return res;
    }
}