class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer,int[]> yValueXLimits = new HashMap<>();
        Map<Integer,int[]> xValueYLimits = new HashMap<>();

        for(int[] building : buildings){
            int x = building[0],y = building[1];

            yValueXLimits.putIfAbsent(y,new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE});
            yValueXLimits.get(y)[0] = Math.min(x,yValueXLimits.get(y)[0]);
            yValueXLimits.get(y)[1] = Math.max(x,yValueXLimits.get(y)[1]);


            xValueYLimits.putIfAbsent(x,new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE});
            xValueYLimits.get(x)[0] = Math.min(y,xValueYLimits.get(x)[0]);
            xValueYLimits.get(x)[1] = Math.max(y,xValueYLimits.get(x)[1]);
        }

        int count = 0;

        for(int[] building : buildings){
            int x = building[0],y = building[1];

            if(x > yValueXLimits.get(y)[0] && x < yValueXLimits.get(y)[1] && xValueYLimits.get(x)[0] < y && xValueYLimits.get(x)[1] > y)
            count++;
        }

        return count;
    }
}