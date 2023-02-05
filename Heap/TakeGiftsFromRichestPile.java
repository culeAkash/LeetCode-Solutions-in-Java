class Solution {
    public long pickGifts(int[] gifts, int k) {
        
        long ans = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int gift : gifts)
            pq.offer(gift);
        
        while(k-- > 0){
            int top = pq.poll();
            
            int rem = getRoot(top);
            pq.offer(rem);
        }
        
        
        while(!pq.isEmpty())
            ans += pq.poll();
        
        return ans;
        
        
    }
    
    public int getRoot(int num){
        int n = 1;
        
        while(n*n<=num){
            n++;
        }
        
        return n-1;
    }
}

