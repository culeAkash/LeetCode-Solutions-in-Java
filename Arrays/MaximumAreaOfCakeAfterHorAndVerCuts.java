class Solution {
    public int maxArea(int h, int w, int[] hor, int[] ver) {
        Arrays.sort(hor);
        Arrays.sort(ver);
        
        long maxDiffHor = hor[0];
        long mod = (long)1e9+7;
        
        for(int i=0;i<hor.length-1;i++){
            int a = hor[i];
            int b = hor[i+1];
            
            if((b-a)>maxDiffHor){
                maxDiffHor = b-a;
            }
                
        }
        
        if((h-hor[hor.length-1])>maxDiffHor)
            maxDiffHor = h - hor[hor.length-1];
        
        long maxDiffVer = ver[0];
        
        for(int i=0;i<ver.length-1;i++){
            int a = ver[i];
            int b = ver[i+1];
            
            if((b-a)>maxDiffVer){
                maxDiffVer = b-a;
            }
                
        }
        
        if((w-ver[ver.length-1])>maxDiffVer)
            maxDiffVer = w - ver[ver.length-1];
        
        return (int)((maxDiffHor * maxDiffVer) % mod);
        
        
    }
}