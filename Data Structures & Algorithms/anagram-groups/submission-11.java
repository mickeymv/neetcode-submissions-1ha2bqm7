class Solution {
    HashMap<HashMap<Character, Integer>, List<String>> mapToStrings= new HashMap<>();
    
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> listOfAnagrams = new ArrayList<>();

        for(String str:strs) {
            HashMap<Character, Integer> charToCount = new HashMap<>();
            for(char ch:str.toCharArray()) {
                charToCount.put(ch, charToCount.getOrDefault(ch, 0)+1);
            }
            if(mapToStrings.containsKey(charToCount)) {
                List<String> strings = mapToStrings.get(charToCount);
                strings.add(str);
            } else {
                List<String> strings = new ArrayList<>();
                strings.add(str);
                mapToStrings.put(charToCount, strings);
            }
        }    

        for(List<String> anagrams : mapToStrings.values()) {
            listOfAnagrams.add(anagrams);
        }

        return listOfAnagrams;
    }


}
