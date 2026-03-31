class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        numberToIndexMap = {};

        for i in range(len(nums)):
            complement = target - nums[i];
            if complement in numberToIndexMap:
                return [numberToIndexMap[complement], i];
            else:
                numberToIndexMap[nums[i]] = i;

        return [];