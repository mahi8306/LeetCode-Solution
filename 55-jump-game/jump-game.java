class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
       int longJump = 0;

       for(int i=0; i<n; i++){
        if(i > longJump){
            return false;
        }

        longJump = Math.max(longJump, i + nums[i]);
       }

       return true;

    }
}