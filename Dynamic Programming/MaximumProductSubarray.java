class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int product =0,maxProduct =Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(product==0)
                product = nums[i];
            else
                product = product * nums[i];
            maxProduct =  Math.max(product,maxProduct);
        }
        
        product =0;
        for(int i=n-1;i>=0;i--){
            if(product==0)
                product = nums[i];
            else
                product = product * nums[i];
            maxProduct =  Math.max(product,maxProduct);
        }
        return maxProduct;
    }
}