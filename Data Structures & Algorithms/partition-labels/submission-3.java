class Solution {

    HashMap<Character, Integer> charToLastIndex = new HashMap<>();

    public List<Integer> partitionLabels(String s) {
        
        List<Integer> partitions = new ArrayList<>();
        
        for(int i=0;i<s.length();i++){
            charToLastIndex.put(s.charAt(i),i);
        }

        int subStringStart=0,subStringEnd=0,index=0;

        while(subStringEnd<s.length()){
            while(index<=subStringEnd) {
                char ch = s.charAt(index);
                subStringEnd = Math.max(charToLastIndex.get(ch), subStringEnd);
                index++;
            }

            int subStringLength = subStringEnd-subStringStart+1;
            subStringStart=subStringEnd+1;
            subStringEnd=subStringStart;
            partitions.add(subStringLength);
        }

        return partitions;
    }
}
