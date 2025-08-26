class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxArea = -1;
        double maxDiagonal = -1.0;
        int index = 0;
        for(int[] d : dimensions){
            double diagVal = Math.sqrt(d[0]*d[0] + d[1]*d[1]);
            int area = d[0] * d[1];
            if(diagVal > maxDiagonal){
                maxArea = area;
                maxDiagonal = diagVal;
            }else if(diagVal==maxDiagonal && area > maxArea){
                maxArea = area;
            }
            index++;
        }

        return maxArea;
    }
}