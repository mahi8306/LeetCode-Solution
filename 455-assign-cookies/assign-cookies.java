class Solution {
    public int findContentChildren(int[] m, int[] s) {

        Arrays.sort(m);
        Arrays.sort(s);

        int i = 0; 
        int j = 0; 
        int count = 0;

        while (i < m.length && j < s.length) {

            if (s[j] >= m[i]) {
               
                count++;
                i++;
                j++;
            } else {
               
                j++;
            }
        }

        return count;
    }
}