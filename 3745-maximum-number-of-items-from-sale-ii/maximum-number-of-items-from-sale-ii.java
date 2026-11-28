
import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;

        int[] freq = new int[n + 1];
        int minPrice = Integer.MAX_VALUE;

    
        for (int[] item : items) {
            freq[item[0]]++;
            minPrice = Math.min(minPrice, item[1]);
        }

        int[] gain = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                gain[i] += freq[j];
            }
            gain[i]--;
        }

        List<int[]> candidates = new ArrayList<>();

        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];

            if (gain[factor] > 0 && 
                price < 2L * minPrice) {

                candidates.add(new int[]{
                    price, gain[factor]
                });
            }
        }

      
        candidates.sort(
            (a, b) -> Integer.compare(a[0], b[0])
        );

       
        long remaining = budget;
        long ans = 0;

        for (int[] item : candidates) {

            long price = item[0];
            long count = item[1];

            long buy = Math.min(count, remaining / price);

            ans += buy * 2;
            remaining -= buy * price;
        }

       
        ans += remaining / minPrice;

        return (int) ans;
    }
}
