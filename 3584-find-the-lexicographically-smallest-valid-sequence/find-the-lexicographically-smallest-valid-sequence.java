import java.util.*;

class Solution {
    public int[] validSequence(String word1, String word2) {
        int a = word1.length();
        int b = word2.length();

        int[] last = new int[b];
        Arrays.fill(last, -1);

        int i = a - 1;
        int j = b - 1;

        while (i >= 0 && j >= 0) {
            if (word1.charAt(i) == word2.charAt(j)) {
                last[j] = i;
                j--;
            }
            i--;
        }

        int[] ans = new int[b];

        boolean mismatchUsed = false;
        j = 0;

        for (i = 0; i < a && j < b; i++) {
            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j] = i;
                j++;
            } 
            else if (!mismatchUsed &&
                     (j == b - 1 || i < last[j + 1])) {
                ans[j] = i;
                j++;
                mismatchUsed = true;
            }
        }

        if (j != b) {
            return new int[0];
        }

        return ans;
    }
}