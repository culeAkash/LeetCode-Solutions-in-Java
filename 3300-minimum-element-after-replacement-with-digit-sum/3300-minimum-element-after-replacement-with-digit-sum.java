class Solution {
    public int minElement(int[] nums) {
        int mini = 100;

        for(int num : nums){
            int sum = sumNum(num);
            mini = Math.min(sum,mini);
        }

        return mini;
    }

    private int sumNum(int num){
        int sum = 0;

        while(num > 0){
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }
}