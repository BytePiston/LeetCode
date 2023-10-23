class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> queue = new PriorityQueue<>((a,b) -> b[0]*b[0]+b[1]*b[1]-a[0]*a[0]-a[1]*a[1]);
        for(int[] point: points){
            queue.offer(point);
            if(queue.size()>k)
                queue.poll();
        }
        int[][] result = new int[k][2];
        while(k>0){
            result[--k] = queue.poll();
        }
        return result;
    }
}