class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i:nums){
            if(map.containsKey(i))
                map.replace(i,map.get(i)+1);
            else
                map.put(i,1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comp());
        
        for(int i:nums){
            if(map.containsKey(i)){
                pq.offer(new Pair(i,map.get(i)));
                if(pq.size()>k)
                    pq.poll();
                map.remove(i);
        }
    }
        int[] ans = new int[k];
        while(!pq.isEmpty())
            ans[--k] = pq.poll().val;
        
        return ans;
        
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

class Comp implements Comparator<Pair>{
    public int compare(Pair p1,Pair p2){
        return p1.freq-p2.freq;
    }
}