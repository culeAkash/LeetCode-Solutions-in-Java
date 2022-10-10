class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>(new Comp());
        
        for(int i=0;i<nums.length;i++){
            pq.offer(nums[i]);
            
            if(pq.size()>k)
                pq.poll();
        }
        return pq.poll();
    }
}

class Comp implements Comparator<String>{
    public int compare(String s1,String s2){
        if (s1.length() == s2.length()) 
                return s1.compareTo(s2);
            else
                return Integer.compare(s1.length(), s2.length());
    }
}