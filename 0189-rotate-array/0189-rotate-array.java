class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;

        int[] nums2 = nums.clone();

        if(len < k){
            int size = k % len;
             System.arraycopy(nums2, 0, nums, size, Math.abs(len - size));
             System.arraycopy(nums2, Math.abs(len - size), nums, 0, size);
        }else{
            System.arraycopy(nums2, 0, nums, k, len - k);
             System.arraycopy(nums2, len - k, nums, 0, k);
        }    
       
    }
}