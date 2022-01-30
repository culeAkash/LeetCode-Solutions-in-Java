class Solution {
    public void sortColors(int[] arr) {
        int size=arr.length;
        if(size==0 || size==1){
            return;
        }
        int nextZero=0;
        int nextTwo=size-1;
        int i=0;
        while(i<=nextTwo){
            if(arr[i]==0){
                int temp= arr[i];
                arr[i]=arr[nextZero];
                arr[nextZero]=temp;
                nextZero++;
                i++;
            }
            else if(arr[i]==2){
                int temp= arr[i];
                arr[i]=arr[nextTwo];
                arr[nextTwo]=temp;
                nextTwo--;
            }
            else{
             i++;   
            }
        }
    }
}
