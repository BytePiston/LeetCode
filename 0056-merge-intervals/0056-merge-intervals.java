class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        int[] curr_interval = intervals[0];
        List<int[]> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(curr_interval);
        for(int[] interval : intervals){
            int currBegin = curr_interval[0];
            int currEnd = curr_interval[1];
            
            int nextBegin = interval[0];
            int nextEnd = interval[1];
            
            if(currEnd >= nextBegin){
                curr_interval[1] = Math.max(currEnd, nextEnd);
            } else {
                curr_interval = interval;
                mergedIntervals.add(curr_interval);
            }
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}