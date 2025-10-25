class Solution {
    public int totalMoney(int n) {
        int week = n / 7;
        int rem = n % 7;
        int ans = 0;
        if(week > 0)
            ans = (7 * (((week - 1)*week)/2)) + week * (28);

        // System.out.println(ans);
        int start = week + 1;
        while(rem-- > 0){
            ans += start++;
        }

        return ans;
    }
}