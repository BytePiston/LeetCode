class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new LinkedList<>();
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int index = 0;
        //newStart < intervals[i][1]
        while(index<intervals.length && intervals[index][1] < newStart){
            result.add(intervals[index++]);
        }

        //newEnd <= intervals[i][0]
        while(index<intervals.length && intervals[index][0] <= newEnd){
            newStart = Math.min(newStart, intervals[index][0]);
            newEnd = Math.max(newEnd, intervals[index][1]);
            index++;
        }
        result.add(new int[]{newStart, newEnd});

        while(index<intervals.length){
            result.add(intervals[index++]);
        }

        int[][] output = new int[result.size()][2];
        for(int i = 0; i<result.size(); i++){
            output[i] = result.get(i);
        }
        return output;
    }
}