class Solution {
    public int maxArea(int[] height) {
        if(height.length==0)
            return 0;
        
        int start = 0, end = height.length - 1;
        int maxVol = Integer.MIN_VALUE;
        
        while(start<end){
            maxVol = Math.max(maxVol,(end-start)*(Math.min(height[start],height[end])));
            if(height[start]>=height[end])
                end --;
            else start++;
        }
        
        return maxVol;
    }
}