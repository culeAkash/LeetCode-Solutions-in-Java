class Solution {
    public double largestTriangleArea(int[][] points) {
        int N = points.length;
        double res = 0.0;
        for(int i=0;i<N-2;i++){
            double x1 = points[i][0],y1 = points[i][1];
            for(int j=i+1;j<N-1;j++){
                double x2 = points[j][0],y2 = points[j][1];
                for(int k=j+1;k<N;k++){
                    double x3 = points[k][0],y3 = points[k][1];

                    double a = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
                    double b = Math.sqrt((x2-x3)*(x2-x3) + (y2-y3)*(y2-y3));
                    double c = Math.sqrt((x3-x1)*(x3-x1) + (y3-y1)*(y3-y1));

                    double s = (a+b+c)/2.0;

                    double area = s * (s-a) * (s-b) * (s-c);
                    area = Math.sqrt(Math.abs(area));
                    res = Math.max(res,area);
                }
            }
        }
        return res;
    }
}