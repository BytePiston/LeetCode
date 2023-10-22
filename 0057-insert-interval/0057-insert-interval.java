class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new LinkedList<>();
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int index = 0;

        // Add all intervals that end before newInterval starts
        while (index < intervals.length && intervals[index][1] < newStart) {
            res.add(intervals[index]);
            index++;
        }

        // Merge intervals that overlap with newInterval
        while (index < intervals.length && intervals[index][0] <= newEnd) {
            newStart = Math.min(newStart, intervals[index][0]);
            newEnd = Math.max(newEnd, intervals[index][1]);
            index++;
        }

        // Add the merged interval
        res.add(new int[]{newStart, newEnd});

        // Add the remaining intervals
        while (index < intervals.length) {
            res.add(intervals[index]);
            index++;
        }

        // Convert the list to a 2D array
        int[][] result = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }

        return result;
    }
}