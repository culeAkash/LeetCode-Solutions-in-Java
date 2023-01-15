class Solution {
    public int differenceOfSum(int[] nums) {
        long elemSum = 0;
        long digSum = 0;
        
        for(int num : nums){
            elemSum += num;
            
            digSum += getDigSum(num);
        }
        
        return (int)Math.abs(elemSum - digSum);
    }
    
    int getDigSum(int num){
        if(num<10)
            return num;
        
        int sum = 0;
        
        while(num!=0){
            sum += (num%10);
            num/=10;
        }
        return sum;
    }
}