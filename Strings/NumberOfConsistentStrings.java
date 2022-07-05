class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for(int i=0;i<allowed.length();i++){
            set.add(allowed.charAt(i));
        }
        
        int count = 0;
        for(String s:words){
            int flag = 1;
            for(int i=0;i<s.length();i++){
                if(!set.contains(s.charAt(i))){
                    flag=0;
                    break;
                }
            }
            if(flag==1)
                count++;
        }
        return count;
    }
}