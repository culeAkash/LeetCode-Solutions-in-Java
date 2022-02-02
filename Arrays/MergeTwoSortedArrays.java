class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m==0){
            for(int i=0;i<n;i++){
                nums1[i]=nums2[i];
            }
            return;
        }
        if(n==0){
            return;
        }
        for(int i=0;i<m;i++){
            if(nums1[i]>=nums2[0]){
                int temp=nums2[0];
                nums2[0]=nums1[i];
                nums1[i]=temp;
                int k=1;
                while(k<n && nums2[k]<nums2[k-1]){
                  int temp1=nums2[k];
                nums2[k]=nums1[k-1];
                nums1[k-1]=temp1;  
                }
            }
        }
        int i=m;
        int j=0;
        while(i<n+m){
            nums1[i++]=nums2[j++];
        }
    }
}