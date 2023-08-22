import java.util.*;

class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int index = 0;
        int cnt = 1;
        for(int i = 0; i < length; i++){
            if(nums[index] != nums[i]){
              nums[++index] = nums[i];
              cnt++;
            }
        }
        return cnt;
    }
}