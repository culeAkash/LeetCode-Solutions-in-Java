class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        TreeMap<Integer,Integer> freq = new TreeMap<>();
        int m = Integer.MAX_VALUE;

        for(int basket : basket1){
            freq.put(basket,freq.getOrDefault(basket,0)+1);
            m = Math.min(m,basket);
        }

        for(int basket : basket2){
            freq.put(basket,freq.getOrDefault(basket,0)-1);
            m = Math.min(m,basket);
        }

        List<Integer> merge = new ArrayList<>();

        for(var entry : freq.entrySet()){
            int count = entry.getValue();
            if((count&1)!=0)return -1;
            // If b1 has 5 and b2 has 3 then 1 must be migrated from b1 to b2 and vice versa
            for(int i=0;i<Math.abs(count)/2;i++)
                merge.add(entry.getKey());
        }

        Collections.sort(merge);
        long res = 0;

        // Now we have to move length(merge)/2 first half must be swapped with second half to maintain min cost
        for(int i=0;i<merge.size()/2;i++){
            // We have two options swap the numbers directly or swap via using the min calculated above to get which will cost 2*m each time
            res += Math.min(2*m,merge.get(i));
        } 

        return res;
    }
}