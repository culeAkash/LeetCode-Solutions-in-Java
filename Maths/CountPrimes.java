class Solution {
    public int countPrimes(int n) {
        if(n<=1)
            return 0;
        
        boolean[] sieve = new boolean[n];
        sieveOfEratosthenes(sieve,n);
        
        int count = 0;
        
        for(boolean b : sieve){
            count = b==false?count+1:count;
        }
        return count;
    }
    
    void sieveOfEratosthenes(boolean[] sieve,int n){
        sieve[0] = sieve[1] = true;//true means they are not prime
        
        for(int i=2;i*i<n;i++){
            if(!sieve[i]){
                int j = i + i;
                while(j<n){
                    sieve[j] = true;
                    j+= i;
                }
                
            }
        }
    }
}