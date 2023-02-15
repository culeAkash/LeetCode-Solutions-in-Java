class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int carry = 0;

        int index = num.length-1;
        while(index>=0){
            int r = k % 10;
            
            int sum = carry;

            sum += num[index] + r;

            num[index--] = sum % 10;
            carry = sum / 10;

            k /= 10;
        }

        List<Integer> res = new ArrayList<>();
        
        carry += k;

        while(carry > 0){
            int r = carry % 10;
            res.add(r);
            carry /= 10;
        }

        Collections.reverse(res);

        for(int n : num)
                res.add(n);
        return  res;


    }
}