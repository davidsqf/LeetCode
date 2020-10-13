// This code is written by davidsqf.
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int p = 0;
        int n = bits.length;
        boolean flag = true;
        while (p < n) {
            if (p == n - 1) {
                flag = true;
                break;
            } else if (p == n - 2) {
                if (bits[p] == 1) {
                    flag = false;
                } else {
                    flag = true;
                }
            }
            
            if (bits[p] == 1) {
                p += 2;
            } else {
                p += 1;
            }
        }
        return flag;
    }
}
