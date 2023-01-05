class Solution {
    public int findMinArrowShots(int[][] points) {
        //Sort the intervals in ascending order of the starting time
        Arrays.sort(points,(a,b)->Integer.compare(a[0],b[0]));
        // for(int i=0;i<points.length;i++){
        //     for(int j=0;j<points[0].length;j++){
        //         System.out.print(points[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        long left = points[0][0];
        long right = points[0][1];

        int end = 1;

        int arrows = 1;

        while(end<points.length){
            if(right<points[end][0]){
                //No overlap conidtion, so just move forward
                left = points[end][0];
                right = points[end][1];
                arrows++;
                end++;
                // System.out.println("no-overlap" + " "+left+" "+right);
            }
            
            else if(right<=points[end][1]){
                //Overlap 1 => Not complete overlap just part of intervals overlapping,remove one of the interval
                left = points[end][0];
                end++;
                // System.out.println("overlap1"+ " "+left+" "+right);
            }
            else if(right>=points[end][1]){
                //Overlap 2 => interval 2 is within the interval 1
                left = points[end][0];
                right = points[end][1];
                end++;
                // System.out.println("overlap2 "+left+" "+right);
            }
            // System.out.println(left+" "+right);
        }
        return arrows;
    }
}