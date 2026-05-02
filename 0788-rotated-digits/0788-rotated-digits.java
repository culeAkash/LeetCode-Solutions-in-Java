class Solution {
    public int rotatedDigits(int n) {
        int count = 0;

        for(int num = 1;num<=n;num++){
            if(isValid(num))
                count++;
        }

        return count;
    }

    private boolean isValid(int num){
        boolean isReqPres = false;
        boolean isNonReqPres = false;

        while(num > 0){
            int r = num % 10;
            if(r == 2 || r==5 || r == 6 || r==9)
                isReqPres = true;
            
            if(r==3 || r==4 || r==7)
                isNonReqPres = true;
            
            num /= 10;
        }

        return isReqPres && !isNonReqPres;
    }
}