class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int size = strs[0].length();
        int count = 0;
        
        for(int i=0;i<size;i++){
            for(int j=0;j<n-1;j++){
                if(strs[j].charAt(i)>strs[j+1].charAt(i)){
                    count++;
                    break;
                }
            }
        }
        return count;

    }
}