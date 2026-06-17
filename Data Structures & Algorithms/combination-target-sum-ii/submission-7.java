class Solution {
    List<List<Integer>> combinations = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        addCombination(0, candidates, target, new ArrayList<>());
        return combinations;
    }

    public void addCombination(int index, int[] candidates, int target, List<Integer> combination) {
        if (target==0) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        if (index>=candidates.length || target<0) {
            return;
        }


        //choose to include candidate 
        int candidate = candidates[index];
        
        combination.add(candidate);
        addCombination(index+1,candidates,target-candidate,combination);
        
        //remove the candidate from candidates list 
        combination.removeLast();
        
        while (index<candidates.length-1 && candidates[index]==candidates[index+1]) {
            index++;
        }
        addCombination(index+1,candidates,target,combination);
    }
}
