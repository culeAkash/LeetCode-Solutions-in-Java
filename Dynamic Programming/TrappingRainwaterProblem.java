class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int water = 0;
        int leftMax = 0,rightMax = 0;
        n--;
        int i=0;
        while(i<n){
            if(arr[i]<arr[n]){
                if(arr[i]>=leftMax)
                    leftMax = arr[i];
                else
                    water += leftMax - arr[i];
                i++;
            }
            else{
                if(arr[n]>=rightMax)
                    rightMax = arr[n];
                else
                    water += rightMax - arr[n];
                n--;
            }
        }
        return water;
    }
}