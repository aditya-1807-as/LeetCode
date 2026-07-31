class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0, new ArrayList<>());
        return ans;
    }

    private void backtrack(int[] candidates, int target, int index, List<Integer> curr) {

        // Found a valid combination
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        // Invalid path
        if (target < 0 || index == candidates.length) {
            return;
        }

        // Choose current number
        curr.add(candidates[index]);
        backtrack(candidates, target - candidates[index], index, curr);

        // Undo choice
        curr.remove(curr.size() - 1);

        // Skip current number
        backtrack(candidates, target, index + 1, curr);
    }
}