class Solution {
    private static final class Pair implements Comparable<Pair>{
        final int count,val;
        Pair(int f,int v){
            this.count = f;
            this.val = v;
        }

        public boolean equals(Object o){
            if(this==o)return true;
            if(!(o instanceof Pair))return false;
            Pair p = (Pair)o;
            return this.count == p.count && this.val == p.val;
        }

        public int hashCode(){
            return Objects.hash(this.count,this.val);
        }

        public int compareTo(Pair b){
        if(this.count!=b.count)return Integer.compare(b.count,this.count);
        return Integer.compare(b.val,this.val);
        }
    }

    private Map<Integer,Integer> freq;
    private TreeSet<Pair> top,rest;
    private long topSum;


    private void pull(int val,int count){
        Pair key = new Pair(count,val);
        if(top.remove(key)){
            topSum -= 1L * val * count;
        }else{
            rest.remove(key);
        }
    }


    private void pushToTop(int val,int count){
        top.add(new Pair(count,val));
        topSum += 1L * val * count;
    }


    private void insertVal(int val,int x){
        int count = freq.getOrDefault(val,0);
        if(count > 0)pull(val,count);

        count++;
        freq.put(val,count);
        pushToTop(val,count);

        while(top.size() > x){
            Pair last = top.last();
            topSum -= 1L * last.val * last.count;
            top.remove(last);
            rest.add(last);
        }
    }

    private void removeVal(int val,int x){
        int count = freq.getOrDefault(val,0);
        if(count==0)return;
        pull(val,count);
        count--;
        if(count==0)freq.remove(val);
        else{
            freq.put(val,count);
            rest.add(new Pair(count,val));
        }

        while(top.size() < x && rest.size() > 0){
            Pair best = rest.first();
            rest.remove(best);
            top.add(best);
            topSum += 1L * best.count * best.val;
        }
    }

    public long[] findXSum(int[] nums, int k, int x) {
        int N = nums.length;
        long[] ans = new long[N-k+1];
        freq = new HashMap<>();
        top = new TreeSet<Pair>();
        rest = new TreeSet<Pair>();
        topSum = 0L;

        for(int i=0;i<k;i++)insertVal(nums[i],x);
        ans[0] = topSum;
        for(int i=k;i<N;i++){
            removeVal(nums[i-k],x);
            insertVal(nums[i],x);
            ans[i-k+1] = topSum;
        }

        return ans;
    }
}