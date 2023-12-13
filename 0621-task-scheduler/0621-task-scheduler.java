class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> taskCount = new HashMap<>();
        for (char task : tasks) {
            taskCount.put(task, taskCount.getOrDefault(task, 0) + 1);
        }

        // Create a max heap based on frequency
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(taskCount.values());

        int cycles = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int k = n + 1; // number of steps in a cycle
            
            // Fill the slots in the current cycle
            for (int i = 0; i < k; i++) {
                if (!maxHeap.isEmpty()) {
                    temp.add(maxHeap.remove());
                }
            }

            // Decrease frequency of each task by 1
            for (int freq : temp) {
                if (--freq > 0) {
                    maxHeap.add(freq);
                }
            }

            // Calculate cycles (handle the last cycle separately)
            cycles += maxHeap.isEmpty() ? temp.size() : k;
        }

        return cycles;
    }
}