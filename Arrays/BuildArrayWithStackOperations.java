class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        
        int num = 1;
        int index = 0;
        
        
        while(num<=n && index<target.length){
            if(num==target[index]){
                res.add("Push");
                num++;
                index++;
            }
            else{
                res.add("Push");
                res.add("Pop");
                num++;
            }
        }
        return res;
    }
}