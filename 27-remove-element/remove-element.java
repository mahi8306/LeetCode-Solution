class Solution {
    public int removeElement(int[] n, int val) {
        int sol = 0;
        for (int i = 0; i <n.length; i++) {
            if (n[i] != val) {
                n[sol] = n[i];
                sol++;
            }
        }

        return sol;
    }
}