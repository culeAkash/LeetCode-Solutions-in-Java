class Solution {
    public int countCollisions(String directions) {
        int count = -1;
        int ans = 0;

        for(int i=0;i<directions.length();i++){
            char ch = directions.charAt(i);

            if(ch=='L'){
                if(count >=0){
                    ans += (count + 1);
                    count = 0;
                }
            }else if(ch=='S'){
                if(count > 0){
                    ans += count;
                }
                count = 0;
            }else{
                if(count >=0)count++;
                else count = 1;
            }
        }

        return ans;
    }
}