class ZigzagIterator {

    Queue<Queue<Integer>> qOfQs = new LinkedList<>();

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        ArrayList<List<Integer>> vectors = new ArrayList<>();
        vectors.add(v1);
        vectors.add(v2);

        for (List<Integer> vector : vectors) {
            Queue<Integer> q = new LinkedList<>();
            for (int num : vector) {
                q.add(num);
            }
            if (q.size()>0) {
                qOfQs.add(q);
            }
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
