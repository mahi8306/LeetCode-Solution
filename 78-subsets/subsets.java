class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(
            int[] nums,
            int index,
            List<Integer> current,
            List<List<Integer>> result) {

        // Current subset ko answer me add karo
        result.add(new ArrayList<>(current));

        // Aage ke elements choose karo
        for (int i = index; i < nums.length; i++) {

            // Take
            current.add(nums[i]);

            // Next element
            backtrack(nums, i + 1, current, result);

            // Undo / Backtrack
            current.remove(current.size() - 1);
        }
    }
}