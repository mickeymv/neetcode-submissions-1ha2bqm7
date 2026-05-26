class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(point -> point[0])
        );

        //add points to heap with their distance as the first element 
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            minHeap.add(new int[]{(x*x)+(y*y), x, y});
        }

        //in Java the heap is automatically heapified, so this is a n*logn operation 

        int[][] result = new int[k][2];

        while(k>0) {
            int [] point = minHeap.poll();
            result[k-1][0]=point[1];
            result[k-1][1]=point[2];
            k--;
        }

        return result;
    }
}
