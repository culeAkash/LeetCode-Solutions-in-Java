class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 3;

        for(int num : arr){
            if((num&1)==1){
                count--;
            }
            else{
                count = 3;
            }

            if(count==0)
                return true;
        }

        return false;
    }
}