class Solution {
    public List<Integer> getRow(int rowIndex) {
       int[] list = new int[rowIndex+1];
        list[0] = 1;
        for(int i=1;i<=rowIndex;i++){
            for(int j=i;j>=1;j--){
                list[j]+=list[j-1];
            }
            
        }
        List<Integer> ans = new ArrayList<>();
        for(int elem:list)
            ans.add(elem);
        return ans;
    }
}