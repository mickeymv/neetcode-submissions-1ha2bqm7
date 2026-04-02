class Solution:
    map = {1:1,
    2:2,
    3:3,
    4:5,
    5:8,
    6:13,
    7:21,
    8:34}
    def climbStairs(self, n: int) -> int:
        if n == 1:
            return 1;
        
        if n == 2:
            return 2;

        if n > 2:
            if n in self.map.keys():
                return self.map[n];
            else:
                fib = self.climbStairs(n-1) + self.climbStairs(n-2);
                self.map[n] = fib;
            return fib; 
        