class Solution:
    def isValid(self, s: str) -> bool:
        openToCloseMap = {'(':')',
        '{':'}',
        '[':']'};

        openingBraces = []

        for brace in s:
            if brace in openToCloseMap.keys():
                openingBraces.append(brace);
            elif brace in openToCloseMap.values():
                if openingBraces:
                    openingBrace = openingBraces.pop();
                    if brace != openToCloseMap[openingBrace]:
                        return False;
                else:
                    return False;
            else:
                return False;
        
        if openingBraces:
            return False; #should be empty at the end

        return True;


        