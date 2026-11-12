
class Solution {
    public int longestMonotonicSubarray(int[] nums) {

        int increase = 1;
        int decrease = 1;
        int ans = 1;
        int n = nums.length ;

        for (int i = 1; i < n; i++) {

            if (nums[i] > nums[i - 1]) {
                increase++;
                decrease = 1;
            }
            else if (nums[i] < nums[i - 1]) {
                decrease++;
                increase = 1;
            }
            else {
                increase = 1;
                decrease = 1;
            }

            ans = Math.max(ans, Math.max(increase, decrease));
        }

        return ans;
    }
}
