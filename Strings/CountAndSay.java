class Solution {
    public String countAndSay(int n) {
        if(n==1)
            return "1";
        
        String s = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();
        
        int i = 0;
        while(i<s.length()){
            int index = i + 1;
            int count = 1;
            
            while(index<s.length() && s.charAt(index)==s.charAt(i)){
                count++;
                index++;
            }
            
            sb.append(count);
            sb.append(s.charAt(i));
            
            i = index;
        }
        
        return sb.toString();
    }
}