class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int ele : batteries) {
            sum += ele;
        }
        long start = 0;
        long end = sum;
        long ans  = 0;
        while(start <= end){
            long mid = (end + start) / 2;

            if(isPossible(mid,batteries,n)){
                ans = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return ans;

    }

    private boolean isPossible(long mid,int[] batteries,int n){
        long usage = 0L;
        for(int power : batteries){
            if(power < mid){
                
                usage += power;
            }else{
                usage += mid;
            }
        }
        return mid * n <= usage;
    }
}