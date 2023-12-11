class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int newBegin = newInterval[0];
        int newEnd = newInterval[1];
        int index = 0;
        
        //Find all the intervals for which our end is less than equal to newBegin;
        while(index<intervals.length && intervals[index][1]<newBegin){
            result.add(intervals[index++]);
        }
        //Find all the intervals for which our start is less than equal to newEnd;
        while(index<intervals.length && intervals[index][0]<=newEnd){
            newBegin = Math.min(newBegin, intervals[index][0]);
            newEnd = Math.max(newEnd, intervals[index][1]);
            index++;
        }
        
        result.add(new int[]{newBegin, newEnd});
        
        //Add remining intervals which are not affected.
        while(index<intervals.length){
            result.add(intervals[index++]);
        }
        return result.toArray(new int[result.size()][]);
    }
}