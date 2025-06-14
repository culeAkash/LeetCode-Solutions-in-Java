class Solution {
    public int minMaxDifference(int num) {
        String s = Integer.toString(num);
        int pos = 0;
        while(pos < s.length() && s.charAt(pos)=='9'){
            pos++;
        }

        String t = s;

        if(pos < s.length()){
           s = s.replace(s.charAt(pos),'9');
        }

        t = t.replace(t.charAt(0),'0');

        return Integer.parseInt(s) - Integer.parseInt(t);
    }
}