class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] remFreq = new int[value];

        for(int num : nums){
            remFreq[((num % value) + value) % value]++;
        }

        int ans = 0;
        while(remFreq[ans % value] > 0){
            remFreq[ans % value]--;
            ans++;
        }

        return ans;
    }
}