class Solution {
    
    HashMap<String,Boolean> cache = new HashMap<>();
    
    public boolean isInterleave(String s1, String s2, String s3) {
        return dfs(s1,s2,s3,0,0,0);
    }

    public boolean dfs(String s1, String s2, String s3,
    int s1Index, int s2Index, int s3Index) {

        if (s1Index==s1.length() && 
        s2Index==s2.length() &&
        s3Index==s3.length()) {
            return true;
            //we successfully interleaved s1 and s2 to get s3 
        }

        if (s3Index==s3.length() && (s1Index!=s1.length() || s2Index!=s2.length())) {
            return false; //reached end of s3 but s1/s2 is not ended
        }

        String key = s1Index+"-"+s2Index;

        if(cache.containsKey(key)){
            return cache.get(key);
        }

        char ch = s3.charAt(s3Index);

        boolean canPickS1 = false, canPickS2 = false;

        if(s1Index<s1.length() && ch==s1.charAt(s1Index)) {
            // we can pick s1
            canPickS1 = true;
        }

        if (s2Index<s2.length() && ch==s2.charAt(s2Index)) {
            //we can pick s2
            canPickS2 = true;
        }

        if (canPickS1 && canPickS2) {
            cache.put(key, dfs(s1,s2,s3,
                        s1Index+1,s2Index,s3Index+1) //pick s1 
                        || 
                        dfs(s1,s2,s3,
                        s1Index,s2Index+1,s3Index+1));
            return cache.get(key);//pick s2
        } else if (canPickS1 && !canPickS2) {
            cache.put(key, dfs(s1,s2,s3,
                        s1Index+1,s2Index,s3Index+1));//pick s1 
                        return cache.get(key);
        } else if (!canPickS1 && canPickS2) {
            cache.put(key, dfs(s1,s2,s3,
                        s1Index,s2Index+1,s3Index+1));//pick s2
                        return cache.get(key);
        } else {
            cache.put(key, false);
            return cache.get(key);
        }

    }
}
