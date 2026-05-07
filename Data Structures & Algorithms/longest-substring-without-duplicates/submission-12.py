class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0:
            return 0  # empty return
        if len(s) == 1:
            return 1

        result = 1

        left = 0

        uniq_chars = set()

        for right in range(len(s)):
            while s[right] in uniq_chars:
                #duplicate found
                #remove from substring 
                uniq_chars.remove(s[left])
                left += 1
                #increment left
            uniq_chars.add(s[right])
            result = max(result, len(uniq_chars))


        return result
