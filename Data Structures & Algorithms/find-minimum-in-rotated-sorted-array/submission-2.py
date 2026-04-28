class Solution:
    def findMin(self, nums: List[int]) -> int:
        length_of_array = len(nums)
        if length_of_array == 1:
            return nums[0]
        
        if nums[0] > nums[length_of_array-1]:
            # array has been rotated, we need to find min in middle of array
            #find half of array and call the findMin on both halves of the array
            minOfFirstHalf = self.findMin(nums[:int(length_of_array/2)])
            minOfSecondHalf = self.findMin(nums[int(length_of_array/2):])

            if minOfFirstHalf < minOfSecondHalf:
                return minOfFirstHalf
            else:
                return minOfSecondHalf
    
        else:
            #array has not been rotated, min is the first element
            return nums[0]    
         