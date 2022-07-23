class Solution {
    public int reversePairs(int[] arr) {
        return mergeSort(arr,0,(arr.length-1));
    }
    
    public int mergeSort(int arr[],int low,int high){
        int counter = 0;
        if(low<high){
            int mid = low+(high-low)/2;
            counter += mergeSort(arr,low,mid);//left half
            counter += mergeSort(arr,mid+1,high);//rigth half
            counter += merge(arr,low,mid,high);//merging left and right arrays
        }
        return counter;
    }
    
    public int merge(int arr[],int low,int mid,int high){
        int counter = 0;
        int n1 = (mid-low+1);
        int n2 = (high-mid);
        int L[] = new int[n1];
        int R[] = new int[n2];
        for(int i=0;i<n1;i++){
            L[i] = arr[low+i];
        }
        for(int j=0;j<n2;j++){
            R[j] = arr[mid+1+j];
        }
        
        int j=0;
        for(int i=0;i<n1;i++)
        {
            while(j<n2 && L[i]>2*(long)R[j])
                j++;
            counter+=j;
        }
        
        int i=0,k=low;
        j=0;
        while(i<n1 && j<n2){
            if(L[i]<=R[j]){
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k++] = L[i++];
        }
        while(j<n2){
            arr[k++] = R[j++];
        }
        return counter;
    }
}