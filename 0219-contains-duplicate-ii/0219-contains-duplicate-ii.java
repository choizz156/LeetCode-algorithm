class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        Map<Integer,Integer> map = new HashMap<>(100001);

        if(k == 0){
            return false;
        }
        
        for(int i = 0; i < len; i++){
           if(map.containsKey(nums[i]) && i - map.get(nums[i]) <= k){
               return true;
           }
           map.put(nums[i], i);
        }
        
        return false;
   }
 
}