class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            if(!map.containsKey(i))
                map.put(i,1);
            else
                map.replace(i,map.get(i)+1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comp());
        for(int i:nums){
            if(map.containsKey(i)){
                pq.offer(new Pair(i,map.get(i)));
                map.remove(i);
            }
        }
        
        int i=0;
        while(!pq.isEmpty()){
            Pair top = pq.poll();
            for(int j=1;j<=top.freq;j++){
                nums[i++] = top.val;
            }
        }
        return nums;
    }
}

class Comp implements Comparator<Pair>{
    public int compare(Pair p1,Pair p2){
        if(p1.freq==p2.freq)
            return p2.val-p1.val;
        else
            return p1.freq-p2.freq;
    }
}

class Pair{
    int val;
    int freq;
    
    public Pair(int val,int freq){
        this.val = val;
        this.freq = freq;
    }
}