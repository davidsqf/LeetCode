// This code is written by davidsqf.
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        // the key of map denotes a character from 'a' to 'z',
        // the value of map denotes an ArrayList recording the positions where the key character appears in the string
        Map<Character, ArrayList<Integer>> map = new HashMap<>();
        // arr is created for later use to record the largest distance each character can give
        int[] arr = new int[26];
        // initialize the map with empty ArrayList
        for (char ch = 'a'; ch <= 'z'; ch++) {
            map.put(ch, new ArrayList<Integer>());
        }
        // scan through the string and update the ArrayLists in the map
        for (int i = 0; i < s.length(); i++) {
            map.get(s.charAt(i)).add(i);
        }
        // after the map has finished updating,
        // scan through the map to calculate the largest distance each character can give,
        // and record the distance in the array arr
        for (char ch = 'a'; ch <= 'z'; ch++) {
            arr[ch - 'a'] = find_largest_distance(map.get(ch));
        }
        // sort arr so that the smallest item in at index 0 and the largest item is at index 25
        // note that in method 'find_largest_distance', it returns -1 if a character does not appear more than once,
        // therefore if there is no character that repeated, then arr[25] will equal to -1, we can return it straightly without the need to do any further manipulation
        Arrays.sort(arr);
        return arr[25];
    }
    
    // returns the largest difference in a given ArrayList
    private int find_largest_distance(ArrayList<Integer> list) {
        int n = list.size();
        if (n == 0) {
            return -1;
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
        return list.get(n - 1) - list.get(0) - 1;
    }
}
