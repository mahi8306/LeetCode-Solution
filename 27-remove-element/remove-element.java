class Solution {
    public int removeElement(int[] n, int val) {
        int s = 0;
        for (int i = 0; i <n.length; i++) {
            if (n[i] != val) {
                n[s] = n[i];
                s++;
            }
        }

        return s;
    }
}