// This code is written by davidsqf.
// Runtime: 2 ms, faster than 98.43% of Java online submissions for Combination Sum II.
// Memory Usage: 39.5 MB, less than 77.56% of Java online submissions for Combination Sum II.
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, comb, res);
        return res;
    }
    private void backtrack(int[] candidates, int target, int start_index, LinkedList<Integer> comb, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(comb));
            return;
        }
        for (int i = start_index; i < candidates.length; i++) {
            if (target - candidates[i] < 0) return;
            if (i > start_index && candidates[i] == candidates[i - 1]) continue;
            comb.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, comb, res);
            comb.removeLast();
        }
    }
}
