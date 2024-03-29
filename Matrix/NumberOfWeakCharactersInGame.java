class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties,(a,b) -> a[0]==b[0] ? a[1]-b[1] : b[0]-a[0]);
        
        int max= 0;
        int count = 0;
        
        for(int[] a : properties){
            if(a[1]<max)
                count++;
            max = Math.max(max,a[1]);
        }
        return count;
    }
}