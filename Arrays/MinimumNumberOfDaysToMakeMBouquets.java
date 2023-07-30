class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int b:bloomDay){
            low = Math.min(b,low);
            max = Math.max(b,max);
        }

        int high = max;

        while(low<=high){
            int mid = low + (high-low)/2;

            int ans = find(mid,m,k,bloomDay);

            if(ans>=m)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return low > max ? -1 : low;
    }


    public int find(int mid,int m,int k,int[] bloomDay){
        int ans = 0;
        int cont = 0;

        for(int b : bloomDay){
            if(b<=mid){
                cont++;
                if(cont==k){
                    ans += 1;
                    cont = 0;
                }
            }
            else{
                cont=0;
            }
        }

        return ans;
    }
}