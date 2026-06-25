class Solution {

    HashMap<Integer, List<Integer>> trusterToTrustee = new HashMap<>();

    public int findJudge(int n, int[][] trust) {
        //the town judge is someone that trusts noone 
        //but also it is someone that everyone else trusts 

        // first we iterate through trust and create a trusts map 

        for(int[] trusts:trust) {
            trusterToTrustee.computeIfAbsent(trusts[0], k->new ArrayList<>()).add(trusts[1]);
        }

        boolean personDoesNotTrustAnyone = false;

        int person=1;

        for(;person<=n;person++){
            if(!trusterToTrustee.containsKey(person)) {
                personDoesNotTrustAnyone = true;
                break;
            }
        }

        if(!personDoesNotTrustAnyone) {
            return -1;
        }

        //person does not trust anyone . now check if they are trusted by everyone

        for(List<Integer> trustees : trusterToTrustee.values()) {
            if(!trustees.contains(person)) {
                return -1;
            }
        }

        return person;
    }
}