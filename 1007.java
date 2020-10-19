// This code is written by davidsqf.
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        // create an array to store on how many tiles does a value appear
        // occurences[i] = the number of tiles that has value i
        int[] occurences = new int[7];
        boolean flag = false;
        int[] occurences_in_A = new int[7];
        int[] occurences_in_B = new int[7];
        // initialize the array
        for (int i = 0; i < 7; i++) {
            occurences[i] = 0;
        }
        // scan through A and B to update occurences
        for (int i = 0; i < A.length; i++) {
            if (A[i] == B[i]) {
                occurences[A[i]]++;
            } else {
                occurences[A[i]]++;
                occurences[B[i]]++;
            }
        }
        // check if there is a value that appeared on every tile
        for (int i = 0; i < 7; i++) {
            if (occurences[i] == A.length) {
                flag = true;
            }
        }
        if (flag == false) {
            return -1;
        }
        // assert there is at least one value that appeared on every tile
        for (int i = 0; i < 7; i++) {
            occurences_in_A[i] = -1;
            occurences_in_B[i] = -1;
        }
        
        for (int i = 0; i < 7; i++) {
            if (occurences[i] == A.length) {
                int times = 0;
                for (int j = 0; j < A.length; j++) {
                    if (A[j] == i) {
                        times++;
                    }
                }
                occurences_in_A[i] = times;
                
                times = 0;
                for (int j = 0; j < B.length; j++) {
                    if (B[j] == i) {
                        times++;
                    }
                }
                occurences_in_B[i] = times;
            }
        }
        
        for (int i = 0; i < 7; i++) {
            if (occurences_in_A[i] != -1) {
                if (occurences_in_A[i] > A.length / 2) {
                    occurences_in_A[i] = A.length - occurences_in_A[i];
                }
            }
            if (occurences_in_B[i] != -1) {
                if (occurences_in_B[i] > B.length / 2) {
                    occurences_in_B[i] = B.length - occurences_in_B[i];
                }
            }
        }
        
        int least_time = Integer.MAX_VALUE;
        for (int i = 0; i < 7; i++) {
            if (occurences_in_A[i] != -1 && occurences_in_A[i] < least_time) {
                least_time = occurences_in_A[i];
            }
            if (occurences_in_B[i] != -1 && occurences_in_B[i] < least_time) {
                least_time = occurences_in_B[i];
            }
        }
        
        return least_time;
    }
}
