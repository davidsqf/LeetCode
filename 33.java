// This code is written by davidsqf.
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
// Memory Usage: 38.4 MB, less than 94.97% of Java online submissions for Search in Rotated Sorted Array.
class Solution {
    public int search(int[] nums, int target) {
        // the pivot is the smallest item, find the pivot
        int pivot = 0, min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                pivot = i;
            }
        }
        // nums[0] is the smallest item in the second array segment, compare target with it to decide which segment to apply binary search
        // if pivot == 0, it means there is no pivot, apply binary search on whole array
        if (pivot == 0) return binary_search(nums, target, 0, nums.length - 1);
        
        if (nums[0] == target) {
            return 0;
        } else if (nums[0] < target) {
            return binary_search(nums, target, 0, pivot - 1);
        } else if (nums[pivot] == target) {
            return pivot;
        } else if (nums[pivot] < target) {
            return binary_search(nums, target, pivot, nums.length - 1);
        } else {
            return -1;
        }
    }
    private int binary_search(int[] nums, int target, int lo, int hi) {
        if (lo < hi) {
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
        } else if (lo > hi) {
            return -1;
        } else {
            if (nums[lo] == target) {
                return lo;
            } else {
                return -1;
            }
        } 
    }
}
