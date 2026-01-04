class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for(int num : nums){
            ans += helper(num);
        }

        return ans;
    }

    private int helper(int num){
        if(num<4)return 0;

        // check for cube root
        int p = (int)(Math.cbrt(num));
        if(p*p*p==num && isPrime(p))
            return 1 + p + (p*p) + num;


        for(int i=2;i*i<=num;i++){
            if(num%i==0){
                int j = num / i;
                if(i!=j && isPrime(i) && isPrime(j)){
                    System.out.println(i + " " + j + " " + num);
                    return 1 + i + j + num;
                }
                return 0;
            }
        }
        return 0;
    }

    private boolean isPrime(int num){
        for(int i=2;i*i<=num;i++){
            if(num%i==0)return false;
        }
        return true;
    }
}