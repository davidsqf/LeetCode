class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        
        PriorityQueue<Integer> allocator = new PriorityQueue<>(intervals.length, 
                                                              new Comparator<Integer>() {
                                                                  public int compare(Integer a, Integer b) {
                                                                      return a - b;
                                                                  }
                                                              });
        Arrays.sort(intervals,
                   new Comparator<int[]>() {
                       public int compare(int[] a, int[] b) {
                           return a[0] - b[0];
                       }
                   });
        allocator.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }
            
            allocator.add(intervals[i][1]);
        }
        
        return allocator.size();
    }
}
