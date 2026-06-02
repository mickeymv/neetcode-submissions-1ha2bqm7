class Solution {
    Map<Integer, Integer> mem = new HashMap<>();
    public int climbStairs(int n) {
        if(mem.containsKey(n)) {
            return mem.get(n);
        }
        
        if (n<=0) {
            return 0;
        }
        if (n==1) {
            return 1;
        }
        if (n==2) {
            return 2;
        }

        mem.put(n-1, climbStairs(n-1));
        mem.put(n-2, climbStairs(n-2));

        mem.put(n, mem.get(n-1)+mem.get(n-2));

        return mem.get(n);
    }
}
