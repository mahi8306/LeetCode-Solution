class Solution {
    public int majorityElement(int[] nums) {
        int freq = 1;
        int ans = nums[0];
        int n = nums.length;

        for(int i=1; i<n; i++){
          if(freq == 0){
            ans = nums[i];
          }
            if(nums[i]== ans){
                freq ++;
            }else 
            {
                freq --;
            }

            if(freq > n/2) {
                return ans ;
            }
        }
        return ans ;
    }
}