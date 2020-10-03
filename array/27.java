// This code is written by davidsqf.
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Element.
// Memory Usage: 37.5 MB, less than 97.11% of Java online submissions for Remove Element.
class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int f = 0; f < nums.length; f++) {
            if (nums[f] != val) {
                nums[i] = nums[f];
                i++;
            }
        }
        return i;
    }
}
