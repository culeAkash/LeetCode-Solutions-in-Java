class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comp());
        for(int i=0;i<arr.length;i++){
                pq.offer(new Pair(arr[i],(int)Math.abs(x-arr[i])));
            
            if(pq.size()>k)
                pq.poll();
        }
        
        List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty())
            ans.add(pq.poll().val);
        
        Collections.sort(ans);
        return ans;
    }
}

class Pair{
    int val;
    int priority;
    
    public Pair(int val,int priority){
        this.val=val;
        this.priority=priority;
    }
}

class Comp implements Comparator<Pair>{
    public int compare(Pair p1,Pair p2){
        if(p2.priority==p1.priority)
            return p2.val-p1.val;
        else
            return p2.priority-p1.priority;
    }
}