class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            Comparator.comparingInt((int[] point) -> point[2]).reversed()
        );

        for(int[] point : points) {
            int x= point[0];
            int y= point[1];
            maxHeap.add(new int[]{x, y, (x*x)+(y*y)});
            if (maxHeap.size()>k) {
                maxHeap.poll(); //to maintain heap of size k
            }
        }

        int[][] result = new int[k][2];

        while(k>0) {
            int[] point = maxHeap.poll();
            result[k-1][0]=point[0];
            result[k-1][1]=point[1];
            k--;
        }

        return result;
    }
}
