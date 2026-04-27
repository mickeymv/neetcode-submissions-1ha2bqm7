class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        sorted_word_to_anagram_sublist = {}
        for word in strs:
            sorted_word = "".join(sorted(word))
            if sorted_word in sorted_word_to_anagram_sublist:
                anagram_sublist = sorted_word_to_anagram_sublist[sorted_word]
                anagram_sublist.append(word)
                sorted_word_to_anagram_sublist[sorted_word] = anagram_sublist
            else:
                sorted_word_to_anagram_sublist[sorted_word] = [word]

        return list(sorted_word_to_anagram_sublist.values())