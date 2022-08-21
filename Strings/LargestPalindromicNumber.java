class Solution {
    public String largestPalindromic(String nums) {
        int[] map = new int[10];
        
        for(int i=0;i<nums.length();i++){
            map[nums.charAt(i) - '0']++;
        }
        
        StringBuilder ans = new StringBuilder();
        
        int odd = -1;
        for(int i=0;i<10;i++){
            if(map[i]%2!=0)
                odd = i;
        }
        
        for(int i=9;i>=0;i--){
            if(ans.length()==0 && i==0)break;//to avoid trailing zeros
            for(int c=0;c<map[i]/2;c++){
                ans.insert(0,i);
            }
        }
        
        StringBuilder a = new StringBuilder(ans);
        a.reverse();
        
        if(odd==-1){
            if(ans.length()==0)return "0";
            return a.toString() + ans.toString();
        }
        
        return a.toString() + odd + ans.toString();
    }
}