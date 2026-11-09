import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        int n = arrival.length;

        // Available servers
        TreeSet<Integer> available = new TreeSet<>();

        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        // Busy servers: [finishTime, serverIndex]
        PriorityQueue<int[]> busy = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int[] count = new int[k];

        for (int i = 0; i < n; i++) {

            // Release servers whose requests are completed
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {

                int[] completed = busy.poll();

                available.add(completed[1]);
            }

            // If all servers are busy, drop the request
            if (available.isEmpty()) {
                continue;
            }

            
            int start = i % k;

           
            Integer server = available.ceiling(start);

           
            if (server == null) {
                server = available.first();
            }

            
            available.remove(server);

            count[server]++;

            int finishTime = arrival[i] + load[i];

            busy.offer(new int[]{finishTime, server});
        }

        int max = 0;

        for (int c : count) {
            max = Math.max(max, c);
        }

        
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                ans.add(i);
            }
        }

        return ans;
    }
}