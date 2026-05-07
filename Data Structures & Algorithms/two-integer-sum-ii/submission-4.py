class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        leftPointer, rightPointer = 0, len(numbers)-1

        while leftPointer < rightPointer:
            result = numbers[leftPointer] + numbers[rightPointer]
            if result < target:
                leftPointer +=1
            elif result > target:
                rightPointer -= 1
            else:
                return [leftPointer+1, rightPointer+1]

        return []
