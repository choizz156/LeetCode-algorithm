class Solution {
    public boolean canJump(int[] nums) {
        int maxSpot=0;
        
        for(int i=0; i<nums.length; i++){
            
            if(maxSpot<i){
                return false;
            }
            
            if(maxSpot<i+nums[i]){
                maxSpot=i+nums[i];
            }
        }
        
        return true;
    }
}