// This code is written by davidsqf.
// Runtime: 2 ms, faster than 99.28% of Java online submissions for Combination Sum.
// Memory Usage: 38.9 MB, less than 99.03% of Java online submissions for Combination Sum.
// This code uses the BACKTRACK approach.
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();
        Arrays.sort(candidates);
        int max_num = target/candidates[0], start_index = 0;
        this.backtrack(target, candidates, max_num, res, comb, start_index);
        return res;
    }
    private void backtrack(int target, int[] candidates, int max_num, List<List<Integer>> res, LinkedList<Integer> comb, int start_index) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(comb));
            return;
        } else if (max_num == 0) {
            return;
        }
        for (; start_index < candidates.length; start_index++) {
            if (target - candidates[start_index] < 0) return;
            comb.add(candidates[start_index]);
            backtrack(target - candidates[start_index], candidates, max_num - 1, res, comb, start_index);
            comb.removeLast();
        }
    }
}
