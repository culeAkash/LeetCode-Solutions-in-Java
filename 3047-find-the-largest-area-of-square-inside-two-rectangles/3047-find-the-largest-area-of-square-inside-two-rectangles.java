class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long maxSide = 0L;
        int N = bottomLeft.length;

        for(int index1=0;index1<N;index1++){
            for(int index2=0;index2<N;index2++){
                if(index1==index2)continue;
                int x1 = Math.max(bottomLeft[index1][0],bottomLeft[index2][0]);
                int x2 = Math.min(topRight[index1][0],topRight[index2][0]);

                int y1 = Math.max(bottomLeft[index1][1],bottomLeft[index2][1]);
                int y2 = Math.min(topRight[index1][1],topRight[index2][1]);

                int width = x2 - x1;
                int length = y2 - y1;


                maxSide = Math.max(maxSide,Math.min(length,width));
            }
        }

        return maxSide*maxSide;
    }
}