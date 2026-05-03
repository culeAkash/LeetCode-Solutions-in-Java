class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length(), m= goal.length();

        if(n!=m)return false;

        return (s+s).contains(goal);
    }
}