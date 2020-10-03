// This code is written by davidsqf.
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Search Insert Position.
// Memory Usage: 38.4 MB, less than 98.89% of Java online submissions for Search Insert Position.
class Solution {
    public int searchInsert(int[] nums, int target) {
        return binary_search_insert(nums, target, 0, nums.length - 1);
    }
    private int binary_search_insert(int[] nums, int target, int lo, int hi) {
        while(true) {
            if (target < nums[lo]) return lo;
            if (target == nums[lo]) return lo;  // tricky: if target is smaller than lo, than should return lo, not lo - 1
            if (target > nums[hi]) return hi + 1;
            if (target == nums[hi]) return hi;
            int this_index = (lo + hi) / 2;
            int this_item = nums[this_index];
            if (target == this_item) {
                return this_index;
            } else if (target > this_item) {
                return binary_search_insert(nums, target, this_index + 1, hi);
            } else {
                return binary_search_insert(nums, target, lo, this_index - 1);
            }
            
        } 
    }
}
