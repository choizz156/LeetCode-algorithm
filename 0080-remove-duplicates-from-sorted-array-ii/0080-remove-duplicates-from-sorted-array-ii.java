class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int flag = 1;
        int index = 1;
        for(int i = 1; i < length; i++){
            if(nums[i] == nums[i - 1]){
                flag++;
                if(flag >= 3){
                    continue;
                }
                nums[index] = nums[i];
                index++;
            }else{
                nums[index] = nums[i];
                index++;
                flag = 1;
            }
        }
        return index;
    }
}