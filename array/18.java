// This code is written by davidsqf.
// Runtime: 5 ms, faster than 91.51% of Java online submissions for 4Sum.
// Memory Usage: 39.2 MB, less than 99.63% of Java online submissions for 4Sum.
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (length < 4) return result;
        Arrays.sort(nums);
        return kSum(0, 4, target, nums);
    }
    public List<List<Integer>> kSum(int start, int k, int target, int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (start + k - 1 >= length || k * nums[start] > target || k * nums[length - 1] < target) {
            return new ArrayList<>();
        }
        if (k == 2) {
            return twoSum(start, target, nums);
        }
        for (int i = start; i < length; i++) {
            if (i == start || nums[i] != nums[i - 1]) {
                for (List list: kSum(i + 1, k - 1, target - nums[i], nums)) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i])));
                    result.get(result.size() - 1).addAll(list);
                }
            }
        }
        return result;
    }
    public List<List<Integer>> twoSum(int start, int target, int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        int i = start, j = length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                result.add(Arrays.asList(nums[i], nums[j]));
                while (i < j && nums[i] == nums[i + 1]) i++;
                while (i < j && nums[j] == nums[j - 1]) j--;
                i++;
                j--;
            } else if (sum > target) {
                while (i < j && nums[j] == nums[j - 1]) j--;
                j--;
            } else {
                while (i < j && nums[i] == nums[i + 1]) i++;
                i++;
            }
        }
        return result;
    }
}
