// This code is written by davidsqf.
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (length < 3) return result;
        Arrays.sort(nums);
        for (int lower_bound = 0; lower_bound < length - 2; lower_bound++) {
            if (nums[lower_bound] > 0) return result;
            if (lower_bound > 0 && nums[lower_bound] == nums[lower_bound - 1]) continue;
            int left = lower_bound + 1;
            int right = length - 1;
            while (left < right) {
                int sum = nums[lower_bound] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[lower_bound], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    left++;
                } else {
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    right--;
                }
            }
        }
        return result;
    }
}
