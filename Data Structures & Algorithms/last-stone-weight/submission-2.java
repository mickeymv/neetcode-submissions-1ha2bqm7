class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size()>1) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();

            if (stone1 == stone2) {
                //do nothing
            } else if (stone1 > stone2) {
                int remainderStone = stone1-stone2;
                maxHeap.add(remainderStone);
            } else if (stone2 > stone1) {
                int remainderStone = stone2-stone1;
                maxHeap.add(remainderStone);
            }
        }

        if (maxHeap.size() == 0) {
            return 0;
        } else {
            return maxHeap.peek();
        }
    }
}
