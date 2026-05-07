class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:

        num_to_its_sequence = {}

        if len(nums) == 0:
            return 0
        
        if len(nums) == 1:
            return 1

        for num in nums:
            if num in num_to_its_sequence:
                continue # do nothing
            else:
                if num+1 in num_to_its_sequence: #a higher sequence exists, add 1 to it 
                    num_to_its_sequence[num] = num_to_its_sequence[num+1] + 1
                    while 1: #keep doing until lower number is not found
                        if num-1 in num_to_its_sequence: #a lower sequence exists, add 1 to it
                            num_to_its_sequence[num-1] = num_to_its_sequence[num] + 1
                            num = num-1
                        else:
                            break
                else:
                    num_to_its_sequence[num] = 1
                    while 1: #keep doing until lower number is not found
                        if num-1 in num_to_its_sequence: #a lower sequence exists, add 1 to it
                            num_to_its_sequence[num-1] = num_to_its_sequence[num] + 1
                            num = num-1
                        else:
                            break

        maxSequence = 0

        for num, seq in num_to_its_sequence.items():
            if seq > maxSequence:
                maxSequence = seq

        return maxSequence
