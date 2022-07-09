class Solution {
    public int maxResult(int[] nums, int k) {
        LinkedList<Integer> q = new LinkedList<>();
        
        q.offer(0);//first element is always taken
        
        for(int i=1;i<nums.length;i++){
            
            while(q.getFirst()< i-k)
                q.removeFirst();
                
                nums[i] = nums[i] + nums[q.getFirst()];
            
            while(!q.isEmpty() && nums[i]>= nums[q.getLast()])
                q.removeLast();
            q.offer(i);
        }
        return nums[nums.length-1];
    }
}