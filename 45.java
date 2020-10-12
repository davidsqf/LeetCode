class Solution {
    public int jump(int[] nums) {
        int length = nums.length;
        if (length < 2) return 0;
        int longest_ladder = nums[0];
        int this_ladder = nums[0];
        int jump = 1;
        for (int i = 1; i < length; i++) {
            if (this_ladder < i) {
                jump++;
                this_ladder = longest_ladder;
            }
            longest_ladder = Math.max(longest_ladder, nums[i] + i);
        }
        return jump;
    }
}
