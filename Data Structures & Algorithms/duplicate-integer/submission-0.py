class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        originals = set();

        for num in nums:
            if num in originals:
                return True;
            else:
                originals.add(num);
        
        return False;

        