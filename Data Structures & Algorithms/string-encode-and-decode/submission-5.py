class Solution:

    def encode(self, strs: List[str]) -> str:

        if len(strs) == 0:
            return "``" # no strings
        elif len(strs) == 1:
            return strs[0] # only one string, no encoding

        #core idea is to encode by having a delimiter between strings
        #the delimiter shouldn't be within the string itself

        # usually this means having an idea about the data being encoded
        # as of now I will choose ## as the delimiter.



        return "~!@#".join(strs)

    def decode(self, s: str) -> List[str]:
        if s == "``":
            return [] # no strings
        elif "~!@#" not in s:
            return [s] # only one string, no encoding
        return s.split("~!@#")

