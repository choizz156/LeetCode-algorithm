import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        int length = nums.length;
        
        if(length == 1){
            return nums[0];
        }

        int mid = length / 2;
        
        Arrays.sort(nums);

        int cnt = 1;
        int ret = 0;
        for(int i = 1; i < length; i++){
           if(nums[i] == nums[i - 1]){
               cnt++;
               if(cnt > mid){
                   ret = nums[i];
                   break;
               }
           }else{
               cnt = 1;
           }
        }
        return ret;
    }
}