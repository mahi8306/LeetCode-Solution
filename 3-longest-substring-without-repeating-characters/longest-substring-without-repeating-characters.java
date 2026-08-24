class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int max = 0;
        int n =  s.length();

        for (int right = 0; right < n; right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}