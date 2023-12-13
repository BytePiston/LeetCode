class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Long> lastExecutionDay = new HashMap<>();
        long totalDays = 0;
        
        for (int task : tasks) {
            if (lastExecutionDay.containsKey(task)) {
                long lastDay = lastExecutionDay.get(task);
                // Check if the cooldown period has passed
                if (totalDays < lastDay + space) {
                    totalDays = lastDay + space;
                }
            }
            totalDays++; // Increment the day after executing a task
            lastExecutionDay.put(task, totalDays); // Update the last execution day of the task
        }
        return totalDays;
    }
}