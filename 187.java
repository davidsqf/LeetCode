class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int L = 10, n = s.length();
        if (L >= n) {
            return new ArrayList<String>();
        }
        
        int a = 4, al = (int) Math.pow(a, L);
        
        Map<Character, Integer> toInt = new
                    HashMap<>() {{put('A', 0); put('C', 1); put('G', 2); put('T', 3);}};
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = toInt.get(s.charAt(i));
        }
        int h = 0;
        Set<Integer> seen = new HashSet();
        Set<String> output = new HashSet();
        
        for (int start = 0; start <= n - L; start++) {
            if (start == 0) {
                for (int i = 0; i < L; i++) {
                    h = h * a + nums[i];
                }
            } else {
                h = h * a - nums[start - 1] * al + nums[start + L - 1];
            }
            
            if (seen.contains(h)) {
                output.add(s.substring(start, start + L));
            }
            seen.add(h);
            
        }
        return new ArrayList<String>(output);
    }
}
