class Solution {
    public int minAddToMakeValid(String s) {

        int pr = 0, sol = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                pr++;
            } else if (pr > 0) {
                pr--;
            } else {
                sol++;
            }
        }

        return pr + sol;
    }
}