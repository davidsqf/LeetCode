// This code is written by davidsqf.
// Runtime: 1 ms, faster than 91.59% of Java online submissions for Trapping Rain Water.
// Memory Usage: 38.4 MB, less than 14.53% of Java online submissions for Trapping Rain Water.
class Solution {
    public int trap(int[] height) {
        // handle the corner case of empty array
        if (height.length == 0) return 0;
        int left_index = 0, right_index = height.length - 1;
        int left = height[left_index], right = height[right_index];
        int sum = 0;
        while (left_index < right_index) {
            // update the height of left and right side of the container
            left = height[left_index];
            right = height[right_index];
            // determine the shorter side of the container
            int shorter = left < right ? left : right;
            // add water of this iteration
            for (int i = left_index; i <= right_index; i++){
                if (height[i] < shorter) {
                    sum += shorter - height[i];
                    height[i] = shorter;
                }
            }
            // determine which side (left/right) to probe
            if (left < right) {
                while (left_index < right_index && height[left_index] <= left) left_index++;
            } else if (right < left) {
                while (left_index < right_index && height[right_index] <= right) right_index--;
            } else {
                while (left_index < right_index && height[left_index] <= left) left_index++;
                while (left_index < right_index && height[right_index] <= right) right_index--;
            }
        }
        return sum;
    }
}
