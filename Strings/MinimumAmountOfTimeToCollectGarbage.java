class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        Map<Character,Integer> map = new HashMap<>();
        int ans = 0;
        map.put('M',0);
        map.put('G',0);
        map.put('P',0);
        boolean[] visit = new boolean[3];
        
        for(int k=garbage.length-1;k>=1;k--){
            String s = garbage[k];
            
            for(int i=0;i<s.length();i++){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
            
            if(map.get('M')!=0){
                ans += map.get('M');
                visit[0] = true;
            }
            
            if(map.get('P')!=0){
                ans += map.get('P');
                visit[1] = true;
            }
            
            if(map.get('G')!=0){
                ans += map.get('G');
                visit[2] = true;
            }
            
            for(int a=0;a<3;a++){
                if(visit[a])
                    ans += travel[k-1];
            }
            
            System.out.println(ans);
            
            map.put('M',0);
            map.put('G',0);
            map.put('P',0);
        }
        
        String s = garbage[0];
        
        for(int i=0;i<s.length();i++){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
            
            if(map.get('M')!=0){
                ans += map.get('M');
            }
            
            if(map.get('P')!=0){
                ans += map.get('P');
            }
            
            if(map.get('G')!=0){
                ans += map.get('G');
            }
        return ans;
        
    }
}