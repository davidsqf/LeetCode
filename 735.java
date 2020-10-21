// This code is written by davidsqf.
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(asteroids[0]);
        for (int i = 1; i < asteroids.length; i++) {
            res = add_one_to_stable(res, asteroids[i]);
        }
        
        int result[] = new int[res.size()];
        for (int i = 0; i < res.size(); i++)  {
            result[i] = res.get(i);
        }
        return result;
    }
    private ArrayList<Integer> add_one_to_stable(ArrayList<Integer> stable, int add_one) {
        // since the array is stable, therefore the items in the array should be of the same sign
        // compare the add_one's sign with the array's sign, if same, then simply add the add_one to the array;
        // if not same, then check if they will collide
        int n = stable.size();
        boolean is_stable = false;
        int i = n - 1;
        while (!is_stable && i >= 0) {
            if (stable.get(i) < 0) {
                stable.add(add_one);
                is_stable = true;
            } else if (stable.get(i) > 0 && add_one > 0) {
                stable.add(add_one);
                is_stable = true;
            } else {
                if (stable.get(i) > Math.abs(add_one)) {
                  is_stable = true;  
                } else if (stable.get(i) == Math.abs(add_one)) {
                    stable.remove(i);
                    is_stable = true;
                } else {
                    stable.remove(i);
                    i--;
                }
            }
        }
        
        if (stable.size() == 0 && !is_stable) {
            stable.add(add_one);
        }
        
        return stable;
    }
}
