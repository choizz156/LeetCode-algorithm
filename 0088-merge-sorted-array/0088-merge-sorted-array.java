import java.util.*;

class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
       Arrays.sort(nums1);

       if(n == 0){
           System.out.println(Arrays.toString(nums1));
           return;
       }

       if(m == 0){
           System.arraycopy(nums2, 0, nums1, 0, n);
           System.out.println(Arrays.toString(nums1));
           return;
       }

       int length = m + n; 
       int index = 0;
       for(int i = 0; i < length; i++){
           if(nums1[i] == 0){
               index = i;
               break;
           }
       }
       
       System.arraycopy(nums2, 0, nums1, index, n);
    
       Arrays.sort(nums1);
       System.out.println(Arrays.toString(nums1));
    }
}