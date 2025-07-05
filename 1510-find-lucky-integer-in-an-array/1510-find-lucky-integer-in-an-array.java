class Solution {
    public int findLucky(int[] arr) {
        Map<Integer,Integer> treeMap = new TreeMap<>();

        for(int num : arr){
            treeMap.put(num,treeMap.getOrDefault(num,0)+1);
        }

        int ans = -1;
        for(int key : treeMap.keySet()){
            if(treeMap.get(key)==key){
                ans = key;
            }
        }
        return ans;
    }
}