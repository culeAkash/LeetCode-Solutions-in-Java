class Solution {
    public int maxSumDivThree(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;
        List<Integer> rem1 = new ArrayList<>();
        List<Integer> rem2 = new ArrayList<>();
        rem1.add(0);
        rem2.add(0);

        for(int num : nums){
            sum += num;
            if((num%3==1) && rem1.size()<3)rem1.add(num);
            if((num%3==2) && rem2.size()<3)rem2.add(num);
        }
        int ans = 0;
        int s1 = 0;
        for(int num1 : rem1){
            s1 += num1;
            int s2 = 0;
            for(int num2 : rem2){
                s2 += num2;
                if((sum-s1-s2)%3==0){
                    ans = Math.max(sum-s1-s2,ans);
                }
            }
        }

        return ans;
    }
}