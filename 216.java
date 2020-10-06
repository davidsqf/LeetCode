// This code is written by davidsqf.
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Combination Sum III.
// Memory Usage: 36.5 MB, less than 95.96% of Java online submissions for Combination Sum III.
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();
        this.backtrack(k, n, 1, comb, res);
        return res;
    }
    private void backtrack(int k, int target, int start, LinkedList<Integer> comb, List<List<Integer>> res) {
        if (k == 0 && target == 0) {
            res.add(new ArrayList<Integer>(comb));// note that if I write "res.add(comb)", then only the reference to comb will be added to res, whereafter any change to comb will also lead to immediate change in res
            return;
        } else if (k == 0 || target < 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (target - i < 0) return;
            comb.add(i);
            this.backtrack(k - 1, target - i, i + 1, comb, res);
            comb.removeLast();
        }
    }
}
