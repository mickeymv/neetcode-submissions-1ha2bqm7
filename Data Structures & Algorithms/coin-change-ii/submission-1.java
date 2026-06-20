class Solution {

    HashMap<String, Integer> cache = new HashMap<>();

    public int change(int amount, int[] coins) {
        return canMakeChange(0, coins, amount);
    }

    public int canMakeChange(int index, int[] coins, int target) {
        if (index>=coins.length) {
            return 0;
        }

        if (target==0) {
            return 1;
            //we were able to make the exact change
        }
        if (target<0) {
            return 0; //we were not able to make change 
        }

        String key = index+"-"+target;

        if(cache.containsKey(key)){
            return cache.get(key);
        }

        //at each step, we can either choose the coin at the index, or skip it 

        cache.put(key, canMakeChange(index, coins, target-coins[index])
                        + canMakeChange(index+1,coins,target));

        return cache.get(key);
    }
}
