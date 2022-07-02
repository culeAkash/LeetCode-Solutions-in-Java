class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,new Comp());
        int max = 0;
        int i=0;
        while(truckSize>0 && i<boxTypes.length){
            if(boxTypes[i][0]<=truckSize){
                max += boxTypes[i][0] * boxTypes[i][1];
                truckSize-=boxTypes[i][0];
            }
            else{
                max += truckSize * boxTypes[i][1];
                truckSize=0;
            }
            i++;
        }
        return max;
    }
}

class Comp implements Comparator<int[]>{
    public int compare(int[] a1,int[] a2){
        return a2[1]-a1[1];
    }
}