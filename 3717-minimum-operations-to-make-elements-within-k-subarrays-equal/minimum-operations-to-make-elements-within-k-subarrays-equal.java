import java.util.*;

class Solution {

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        // Step 1: Calculate cost of every window of size x
        long[] cost = new long[n - x + 1];

        DualHeap dh = new DualHeap();

        for (int i = 0; i < n; i++) {

            dh.add(nums[i]);

            if (i >= x) {
                dh.remove(nums[i - x]);
            }

            if (i >= x - 1) {
                cost[i - x + 1] = dh.getCost();
            }
        }

        // Step 2: DP
        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[k + 1][n + 1];

        for (int j = 1; j <= k; j++) {
            Arrays.fill(dp[j], INF);
        }

        // Step 3: Choose k non-overlapping windows
        for (int j = 1; j <= k; j++) {

            for (int i = 1; i <= n; i++) {

                // Option 1: Skip current position
                dp[j][i] = dp[j][i - 1];

                // Option 2: Select window ending at i-1
                if (i >= x && dp[j - 1][i - x] != INF) {

                    long pick = dp[j - 1][i - x] + cost[i - x];

                    dp[j][i] = Math.min(dp[j][i], pick);
                }
            }
        }

        return dp[k][n];
    }

    // Maintains lower and upper halves of sliding window
    class DualHeap {

        TreeMap<Integer, Integer> low = new TreeMap<>();
        TreeMap<Integer, Integer> high = new TreeMap<>();

        int lowSize = 0;
        int highSize = 0;

        long lowSum = 0;
        long highSum = 0;

        void add(int val) {

            if (low.isEmpty() || val <= low.lastKey()) {
                insert(low, val);
                lowSize++;
                lowSum += val;
            } else {
                insert(high, val);
                highSize++;
                highSum += val;
            }

            balance();
        }

        void remove(int val) {

            if (low.containsKey(val)) {
                erase(low, val);
                lowSize--;
                lowSum -= val;
            } else {
                erase(high, val);
                highSize--;
                highSum -= val;
            }

            balance();
        }

        void balance() {

            while (lowSize > highSize + 1) {

                int val = low.lastKey();

                erase(low, val);
                lowSize--;
                lowSum -= val;

                insert(high, val);
                highSize++;
                highSum += val;
            }

            while (lowSize < highSize) {

                int val = high.firstKey();

                erase(high, val);
                highSize--;
                highSum -= val;

                insert(low, val);
                lowSize++;
                lowSum += val;
            }
        }

        long getCost() {

            int median = low.lastKey();

            long leftCost = (long) median * lowSize - lowSum;

            long rightCost = highSum - (long) median * highSize;

            return leftCost + rightCost;
        }

        void insert(TreeMap<Integer, Integer> map, int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        void erase(TreeMap<Integer, Integer> map, int val) {

            int count = map.get(val);

            if (count == 1) {
                map.remove(val);
            } else {
                map.put(val, count - 1);
            }
        }
    }
}