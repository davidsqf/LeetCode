class Solution {
    public int maxArea(int[] height) {
        int length = height.length;
        int p = 0, q = length - 1;
        int currLeft = height[p], currRight = height[q];
        int currMax = (q - p) * (currLeft > currRight ? currRight : currLeft);
        
        while (p < q) {
          if (currLeft > currRight) {
              while (q > p) {
                  q--;
                  if (height[q] > currRight) break;
              }
               
              currRight = height[q];
              int curr = (q - p) * (currLeft > currRight ? currRight : currLeft);
              if (curr > currMax) currMax = curr;
          } else {
              while (p < q) {
                  p++;
                  if (height[p] > currLeft) break;
              }
              
              currLeft = height[p];
              int curr = (q - p) * (currLeft > currRight ? currRight : currLeft);
              if (curr > currMax) currMax = curr;
           }
        }
        
        
        return currMax;
    }
}