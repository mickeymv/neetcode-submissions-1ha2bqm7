class Solution:
    def hammingWeight(self, n: int) -> int:
        w = 0;
        for i in range(32):
            if n % 2 == 1:
                w += 1;
            n = n >> 1;
        return w; 
        