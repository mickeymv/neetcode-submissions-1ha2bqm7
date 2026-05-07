class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        three_sum_tuples = set()
        nums.sort()

        for i in range(len(nums) - 2):

            if i > 0 and nums[i] == nums[i-1]:
                continue # skip number if already processed to avoid duplicates

            firstNumber = nums[i]
            target_two_sum = -firstNumber

            left_pointer, right_pointer = i + 1, len(nums) - 1

            while left_pointer < right_pointer:
                two_sum = nums[left_pointer] + nums[right_pointer]

                if two_sum > target_two_sum:
                    right_pointer -= 1
                elif two_sum < target_two_sum:
                    left_pointer += 1
                else:
                    three_sum = [nums[i], nums[left_pointer], nums[right_pointer]]
                    three_sum_tuples.add(tuple(three_sum))
                    left_pointer += 1
                    right_pointer -= 1

        return [list(tuple1) for tuple1 in three_sum_tuples]
