// This code is written by davidsqf.
// Runtime: 4 ms, faster than 88.16% of Java online submissions for 3Sum Closest.
// Memory Usage: 38.9 MB, less than 81.72% of Java online submissions for 3Sum Closest.
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        int diff = 9999;
        int sum = 9999;
        Arrays.sort(nums);
        for (int i = 0; i < length - 2; i++) {
            int j = i + 1;  // j is the left pointer
            int k = length - 1; // k is the right pointer
            while (j < k) {
                int curr_sum = nums[i] + nums[j] + nums[k];
                int curr_diff = curr_sum - target;
                curr_diff = curr_diff < 0 ? 0 - curr_diff : curr_diff;
                if (curr_diff < diff) {
                    diff = curr_diff;
                    sum = curr_sum;
                }
                if (curr_sum == target) {
                    return sum;
                } else if (curr_sum > target) {
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    k--;
                } else {
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    j++;
                }
            }
            
        }
        return sum;
    }
}
