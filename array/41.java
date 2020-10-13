// This code is written by davidsqf.
class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean is_one = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                is_one = true;
                break;
            }
        }
        if (!is_one) return 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) nums[i] = 1;
        }
        for (int i = 0; i < nums.length; i++) {
            int this_one = Math.abs(nums[i]);
            if (nums[this_one - 1] > 0) nums[this_one - 1] *= (-1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return i + 1;
        }
        return nums.length + 1;
    }
}
