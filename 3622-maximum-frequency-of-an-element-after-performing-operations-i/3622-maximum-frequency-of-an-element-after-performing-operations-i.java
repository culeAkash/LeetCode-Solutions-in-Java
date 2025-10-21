class Solution {
    public int maxFrequency(int[] nums, int k, int ops) {
        int maxi = Arrays.stream(nums).max().getAsInt();
        Map<Integer,Integer> mpp = new HashMap<>();
        for(int num : nums){
            mpp.put(num,mpp.getOrDefault(num,0)+1);
        }

        int N = maxi + k + 2;

        int[] pre = new int[N];
        pre[0] = mpp.getOrDefault(0,0);
        for(int i=1;i<N;i++)pre[i] = pre[i-1] + mpp.getOrDefault(i,0);

        int ans = 0;
        for(int i=0;i<N;i++){
            if(mpp.getOrDefault(i,0)==0 && ops==0)continue;
            int l = Math.max(0,i-k), r = Math.min(N-1,i+k);
            // System.out.println(i + " " + mpp.getOrDefault(i,0) + " " + l + " " + r);
            int total = pre[r] - (l > 0 ? pre[l - 1] : 0);
            int adj = total - mpp.getOrDefault(i,0);
            int val = mpp.getOrDefault(i,0) + Math.min(ops,adj);// we can make max ops elements equal to i
            ans = Math.max(ans,val);

        }

        return ans;
    }
    
}