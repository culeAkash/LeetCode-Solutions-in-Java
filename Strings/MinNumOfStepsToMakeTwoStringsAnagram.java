class Solution {
    public int minSteps(String s, String t) {
        if(s.length()==0)
            return t.length();
        if(t.length()==0)
            return s.length();
        
        int[] freq= new int[26];
        boolean[] f= new boolean[26];
        
        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            freq[ch-'a']++;
            f[ch-'a']=true;
        }
        
         
        
        for(int i=0;i<t.length();i++){
            char ch= t.charAt(i);
            if(f[ch-'a'] && freq[ch-'a']>0){
                    freq[ch-'a']--;
                if(freq[ch-'a']==0)
                    f[ch-'a']=false;
            }
            else
                freq[ch-'a']++;
        }
        
        
        
        
        int count=0;
        for(int i=0;i<26;i++){
            // System.out.print(freq[i]+" ");
            count+=freq[i];
        }
        return count;
    }
}