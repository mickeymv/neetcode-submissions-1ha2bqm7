class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        sorted_word_to_anagram_sublist = defaultdict(list)
        
        for word in strs:
            sorted_word = "".join(sorted(word))
            sorted_word_to_anagram_sublist[sorted_word].append(word)

        return list(sorted_word_to_anagram_sublist.values())