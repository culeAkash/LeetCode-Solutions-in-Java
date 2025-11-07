class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int N = stations.length;
        long[] power = new long[N+1];

        for(int index=0;index<N;index++){
            int left = Math.max(0,index-r);
            int right = Math.min(N,index+r+1);
            power[left] += stations[index];
            power[right] -= stations[index];
        }

        long start = Arrays.stream(stations).min().getAsInt();
        long end = Arrays.stream(stations).asLongStream().sum() + k;

        long ans = 0;

        while(start<=end){
            long mid = start + (end - start)/2;
            if(isValid(mid,power,r,k)){
                ans = mid;
                start = mid + 1;
            }else{
                end = mid-1;
            }
        }

        return ans;
    }

    private boolean isValid(long target,long[] power,int r,int k){
        long sum = 0;
        long[] diff = power.clone();
        int N = power.length - 1;
        int rem = k;
        for(int index=0;index<N;index++){
            sum += diff[index];
            if(sum < target){
                long additional = target - sum;
                if(additional > rem)return false;
                rem -= additional;
                sum += additional;
                int right = Math.min(index + 2*r+1,N);
                diff[right] -= additional;
            }
        }
        return true;
    }
}