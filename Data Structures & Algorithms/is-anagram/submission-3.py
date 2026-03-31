class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        sMap = {};
        tMap = {};

        for char in s:
            if char in sMap:
                sMap[char] += 1;
            else:
                sMap[char] = 1;

        for char in t:
            if char in tMap:
                tMap[char] += 1;
            else:
                tMap[char] = 1;

        for char in s:
            if char in tMap:
                if tMap[char] != sMap[char]:
                    return False;
            else:
                return False;

        for char in t:
            if char in sMap:
                if tMap[char] != sMap[char]:
                    return False;
            else:
                return False;

        return True;