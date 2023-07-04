class Solution {
    public boolean buddyStrings(String s, String goal) {
        int nOrig = s.length();
        int nGoal = goal.length();

        if(nOrig!=nGoal){
            return false;
        }

        if(s.equals(goal)){
            int[] counts = new int[26];
            for(char ch : s.toCharArray()){
                counts[ch - 'a']++;
                if(counts[ch - 'a']==2)
                    return true;
            }
            return false;
        }

        List<Integer> ans = new ArrayList<>();

        for(int i=0 ; i<nOrig;i++){
            if(s.charAt(i)!=goal.charAt(i)){
                ans.add(i);
                if(ans.size() > 2)
                    return false;
            }
        }

        return ans.size()==2 && s.charAt(ans.get(0))==goal.charAt(ans.get(1)) && s.charAt(ans.get(1))==goal.charAt(ans.get(0));
    }
}