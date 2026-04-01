def normalize(s: str):
    chars = [];
    for char in s:
        if char.isalnum():
            chars.append(char.lower());
    return ''.join(chars);



class Solution:
    def isPalindrome(self, s: str) -> bool:
        normalizedStr = normalize(s);
        return normalizedStr == normalizedStr[::-1]

        