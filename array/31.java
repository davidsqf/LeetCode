// This code is written by davidsqf.
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Next Permutation.
// Memory Usage: 39.1 MB, less than 97.97% of Java online submissions for Next Permutation.
class Solution {
    public void nextPermutation(int[] nums) {
        // From right to left, find the first descending digit to be replaced.
        int i = nums.length - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) i--;
        // If there is no next permutation, return the smallest permutation, i.e. reverse the array.
        if (i == 0) {
            reverse(nums, i, nums.length - 1);
        } else {
            int to_be_replaced = i - 1;
            // Find the smallest digit that is greater than nums[to_be_replaced] and swap it with nums[to_be_replaced]. 
            // Note that the array to the right of to_be_replaced is in descending order, so starting from the right end, the first item greater than nums[to_be_replaced] is the digit we are looking for.
            int j = nums.length - 1;
            while (j > to_be_replaced + 1 && nums[j] <= nums[to_be_replaced]) j--;
            swap(nums, to_be_replaced, j);
            // Re-order the digits to the right of nums[to_be_replaced] in ascending order, i.e. reverse them.
            reverse(nums, i, nums.length - 1);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
