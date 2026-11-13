import java.util.*;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        Deque<long[]> dq = new ArrayDeque<>();
        long cost = 0, count = 0;
        int r = n - 1;
        for (int l = n - 1; l >= 0; l--) {
            long len = 1;
            while (!dq.isEmpty() && dq.peekFirst()[0] <= nums[l]) {
                long[] seg = dq.pollFirst();
                cost += (nums[l] - seg[0]) * seg[1];
                len += seg[1];
            }
            dq.addFirst(new long[]{nums[l], len});
            while (cost > k) {
                long[] seg = dq.peekLast();
                cost -= seg[0] - nums[r];
                seg[1]--;
                if (seg[1] == 0) dq.pollLast();
                r--;
            }
            count += r - l + 1;
        }
        return count;
    }
}