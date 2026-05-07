class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0:
            return 0 # empty return 
        if len(s) == 1:
            return 1

        length_of_longest_substring = 1

        left_pointer, right_pointer = 0, 0

        uniq_chars_substring = set()

        while left_pointer < len(s)-1 and right_pointer < len(s):
            if s[right_pointer] in uniq_chars_substring:
                #duplicate found, increment left until dup char is removed
                while s[left_pointer] != s[right_pointer]:
                    uniq_chars_substring.remove(s[left_pointer])
                    left_pointer += 1
                uniq_chars_substring.remove(s[left_pointer]) #remove dup
                left_pointer += 1 #move past dup

            else:
                #char is unique, add it to the substring
                uniq_chars_substring.add(s[right_pointer])
                right_pointer += 1
                if len(uniq_chars_substring) > length_of_longest_substring:
                    length_of_longest_substring = len(uniq_chars_substring)

        return length_of_longest_substring

        