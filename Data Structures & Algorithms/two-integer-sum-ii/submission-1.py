class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        for outerIndex in range(len(numbers)):
            for innerIndex in range(1, len(numbers)):
                if numbers[outerIndex] + numbers[innerIndex] == target:
                    return [outerIndex+1, innerIndex+1]

        
        return [] # change after impl
        