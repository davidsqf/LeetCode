// This code is written by davidsqf.
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
// Memory Usage: 44 MB, less than 19.82% of Java online submissions for Find First and Last Position of Element in Sorted Array.
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = find_start(nums, target);
        res[1] = find_end(nums, target);
        return res;
    }
    private int find_start(int[] nums, int target) {
        int curr_left_most = -1;
        int temp = binary_search(nums, target, 0, nums.length - 1);
        while (temp != -1) {
            curr_left_most = temp;
            temp = binary_search(nums, target, 0, curr_left_most - 1);
        }
        return curr_left_most;
    }
    private int find_end(int[] nums, int target) {
        int curr_right_most = -1;
        int temp = binary_search(nums, target, 0, nums.length - 1);
        while (temp != -1) {
            curr_right_most = temp;
            temp = binary_search(nums, target, curr_right_most + 1, nums.length - 1);
        }
        return curr_right_most;
    }
    private int binary_search(int[] nums, int target, int lo, int hi) {
        while (lo < hi) {
            // case: lo < hi
            int this_index = (lo + hi) / 2;
            int this_item = nums[this_index];
            if (this_item == target) {
                return this_index;
            } else if (this_item < target) {
                return binary_search(nums, target, this_index + 1, hi);
            } else {
                return binary_search(nums, target, lo, this_index - 1);
            }
        }
        if (lo > hi) return -1; // handle the testcase of empty array, i.e, array length = 0
        if (nums[lo] == target) {
            return lo;
        } else {
            return -1;
        }
    }
}
