class Solution {
    public long kMirror(int k, int n) {
        long sum = 0;

        int length = 1;
        int count = 0;

        while(count < n){
            int start = (int)(Math.pow(10,(length-1) / 2));
            int end = (int)(Math.pow(10,(length+1) / 2));

            for(int i=start;i<end;i++){
                long palin = i;
                for(int j = (length % 2) == 0 ? i : i/10;j>0;){
                    palin = palin * 10 + (j%10);
                    j = j / 10;
                }
                String kPalindromeStr = Long.toString(palin,k);
                if(kPalindromeCheck(kPalindromeStr.toCharArray())){
                    sum += palin;
                    count++;
                }

                if(count==n){
                    return sum;
                }
            }
            length++;
        }

        return sum;
    }

    boolean kPalindromeCheck(char[] nums){
            int start = 0, end = nums.length - 1;
            while(start<end){
                if(nums[start]!=nums[end])
                    return false;
                start++;
                end--;
            }
            return true;
        }
}