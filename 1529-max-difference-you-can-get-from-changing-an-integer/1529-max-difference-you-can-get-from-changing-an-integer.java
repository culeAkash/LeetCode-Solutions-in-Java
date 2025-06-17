class Solution {
    public int maxDiff(int num) {
        int firstNotNine = -1;
        int firstNotOne = -1;
        int replaceOne = 0;

        int a = 0,b = 0;

        List<Integer> nums = new ArrayList<>();

        while(num > 0){
            int r = num % 10;
            nums.add(r);
            num /= 10;
        }

        int N = nums.size();
        int mul = 10;

        if(nums.get(N-1)!=1){
            replaceOne = 1;
        }
        for(int i=N-1;i>=0;i--){
            int n = nums.get(i);

            if(n!=9 && firstNotNine==-1){
                firstNotNine = n;
            }

            if(n>1 && firstNotOne==-1){
                firstNotOne = n;
            }

            a = (a * mul) + (firstNotNine == n ? 9 : n);
            b = (b * mul) + (firstNotOne == n ? replaceOne : n);
         }
        // System.out.println(a + " " + b);
         return a - b;
    }
}