import java.util.Arrays;
class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int total = 0;
        int max = 0;
        for (int i = 0; i <n; i++) {
            max = Math.max(max , nums[i]);
        }for(int i = 0; i<n ; i++){
            total += max - nums[i];
        }
        return total; 

    }
}
