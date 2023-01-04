class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<tasks.length;i++){
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        }

        int count = 0;
        for(Integer val : map.values()){
            if(val<2)
                return -1;
            
            if(val==2)
                count+=1;
            else{
                double res = val/3.0;
                count += (int)Math.ceil(res);
            }
        }
        return count;
    }
}