class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] s1Arr = s1.toCharArray();
        Arrays.sort(s1Arr);
        String s1Sorted = new String(s1Arr);

        for (int i=0;i<s2.length()-s1.length()+1;i++) {

            char[] s2SubArr = s2.substring(i, i+s1.length()).toCharArray();
            Arrays.sort(s2SubArr);
            String s2SortedSubArr = new String(s2SubArr);

            if (s1Sorted.equals(s2SortedSubArr)) {
                return true;
            }

        }

        return false;
    }
}
