// This code is written by davidsqf.
class KthLargest {
    private int k;
    private int[] nums;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
    }
    
    public int add(int val) {
        int[] temp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        temp[nums.length] = val;
        Arrays.sort(temp);
        nums = temp;
        return nums[nums.length - k];
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
