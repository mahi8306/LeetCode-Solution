
import java.util.*;

class Solution {

    public int[] findSubtreeSizes(int[] parent, String s) {

        int n = parent.length;

        List<Integer>[] tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        // Build original tree
        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        int[] newParent = parent.clone();

        int[] last = new int[26];
        Arrays.fill(last, -1);

        int[] previous = new int[n];
        int[] order = new int[n];

        // Iterative DFS with enter/exit events
        int[] stack = new int[2 * n];
        int top = 0;
        int size = 0;

        stack[top++] = 1; // Enter node 0 (node + 1)

        while (top > 0) {

            int event = stack[--top];

            if (event < 0) {

                // Exit event: restore previous character position
                int node = -event - 1;
                int ch = s.charAt(node) - 'a';

                last[ch] = previous[node];

            } else {

                // Enter event
                int node = event - 1;

                order[size++] = node;

                int ch = s.charAt(node) - 'a';

                previous[node] = last[ch];

                if (last[ch] != -1) {
                    newParent[node] = last[ch];
                }

                last[ch] = node;

                // Schedule exit event
                stack[top++] = -(node + 1);

                // Visit children
                for (int child : tree[node]) {
                    stack[top++] = child + 1;
                }
            }
        }
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        for (int i = size - 1; i > 0; i--) {

            int node = order[i];

            ans[newParent[node]] += ans[node];
        }

        return ans;
    }
}
