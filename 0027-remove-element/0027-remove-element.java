import java.util.*;

class Solution {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int cnt = 0;
        for(int i = 0; i < length; i++){
            if(nums[i] == val){
                nums[i] = 51;
                continue;
            }
          cnt++;
        }
        
        Arrays.sort(nums);
        return cnt;
    }
}