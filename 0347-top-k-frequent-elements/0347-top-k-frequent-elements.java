class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            map.merge(num, 1, Integer::sum);
        }
        Queue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        for(Integer key: map.keySet()){
            pq.offer(key);
        }
        int[] output = new int[k];
        for(int i=0; i<k; i++)
            output[i] = pq.poll();
        return output;
    }
}