// This code refers to LeetCode @mycoy02.
// Great idea to use hashmap to serve as a dictionary of sums.
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                // If there is this sum, increase it by 1.
                // If there isn't this sum, initialize it with 1.
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        for (int c : C) {
            for (int d : D) {
                int sum = c + d;
                result += map.getOrDefault(-sum, 0);
            }
        }
        return result;
    }
