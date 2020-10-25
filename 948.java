/**
* Sort the tokens.
* As long as we can afford the smallest token, face up;
* if we don't have enough power to face up AND it is beneficial to face down the largest, face down.
*/
class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        int left = 0, right = tokens.length - 1;
        int score = 0;
        
        if (tokens.length == 0) return 0;
        
        Arrays.sort(tokens);
        if (P < tokens[0]) return 0;
        
        while (left <= right) {
            if (P >= tokens[left]) {
                P -= tokens[left];
                score++;
                left++;
            } else {
                // no enough power to face up
                if (right - left > 1) {
                    // i.e. it would be wise to lose one score and face down the largest token
                    score--;
                    P += tokens[right];
                    right--;
                } else {
                    // i.e. no need to face down
                    break;
                }
            }
        }
        return score;
    }
}
