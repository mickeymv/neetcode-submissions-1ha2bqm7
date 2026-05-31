class ZigzagIterator {

    Queue<Queue<Integer>> qOfQs = new LinkedList<>();

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        Queue<Integer> firstQ = new LinkedList<>();
        for (int num : v1) {
            firstQ.add(num);
        }
        if (firstQ.size()>0) {
            qOfQs.add(firstQ);
        }
        Queue<Integer> secondQ = new LinkedList<>();
        for (int num : v2) {
            secondQ.add(num);
        }
        if (secondQ.size()>0) {
            qOfQs.add(secondQ);
        }
    }

    public int next() {
        Queue<Integer> q = qOfQs.poll();
        int num = q.poll();
        if (q.size()>0) {
            qOfQs.add(q);
        }
        return num;
    }

    public boolean hasNext() {
        if (qOfQs.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
