class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        start, end = 0, len(nums)-1

        while start<=end:
            distance = int((end-start) / 2)
            half = distance + start
            val = nums[half]

            if val == target:
                return half;
            elif val < target:
                start = half + 1;
            else:
                end = half-1;

        return -1;


        