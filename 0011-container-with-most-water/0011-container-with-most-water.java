class Solution {
    public int maxArea(int[] height) {
        int start = 0, end = height.length - 1;
        int res = Integer.MIN_VALUE;

        while(start < end){
            res = Math.max(res,(end - start) * Math.min(height[start],height[end]));
            if(height[start] <= height[end]){
                start++;
            }else{
                end--;
            }
        }

        return res;
    }
}