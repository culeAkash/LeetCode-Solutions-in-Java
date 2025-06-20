class Solution {
    public int maxDistance(String s, int k) {
        int latitude = 0;
        int longitude = 0;

        int ans = 0;
        int i = 0;
        for(char ch : s.toCharArray()){
            switch(ch){
                case 'N':
                    latitude++;
                    break;
                case 'S':
                    latitude--;
                    break;
                case 'W':
                    longitude--;
                    break;
                case 'E':
                    longitude++;
                    break;
            }

            ans = Math.max(ans,
                Math.min(
                    Math.abs(latitude) + Math.abs(longitude) + k * 2,
                    i+1
                )
            );
            i++;
        }

        return ans;
    }
}