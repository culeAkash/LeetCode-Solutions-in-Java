class Solution {
    public long gcdSum(int[] nums) {
        List<Integer> gcds = new ArrayList<>();

        int maxi = -1;

        for(int num : nums){
            maxi = Math.max(num,maxi);

            gcds.add(gcd(maxi,num));
        }

        Collections.sort(gcds);

        int start = 0,end = gcds.size()-1;
        long res = 0;
        while(start<end){
            res += gcd(gcds.get(start++),gcds.get(end--));
        }
        return res;
    }

    private int gcd(int num1,int num2){
        while(num2!=0){
            int temp = num1;
            num1 = num2;
            num2 = temp % num2;
        }
        return num1;
    }
}