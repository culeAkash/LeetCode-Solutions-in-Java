class Solution {
    public int maximum69Number (int num) {
        List<Integer> temp = new ArrayList<>();
        while(num > 0){
            int r = num % 10;
            temp.add(0,r);
            num = num / 10;
        }

        int ans = 0;
        int flg = 0;
        for(int n : temp){
            if(flg== 0 && n==6){
                ans = ans * 10 + 9;
                flg = 1;
            }else{
                ans = ans * 10 + n;
            }
        }

        return ans;

    }
}