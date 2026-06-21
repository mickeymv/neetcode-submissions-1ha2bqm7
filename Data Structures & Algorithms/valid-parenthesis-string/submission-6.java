class Solution {

    HashMap<String, Boolean> cache = new HashMap<>();

    public boolean checkValidString(String s) {
        //we can use recursion to check if at any point we have a valid string 
        //when we have a wildcard 

        return check(0,s,0);
    }

    public boolean check(int i, String s, int openLeftPs) {
        if(i==s.length() && openLeftPs==0) {
            return true;
        }

        if (i>=s.length() || openLeftPs<0) {
            return false;
        }

        String key = i+"-"+openLeftPs;

        if(cache.containsKey(key)){
            return cache.get(key);
        }

        char c = s.charAt(i);

        if (c=='(') {
            cache.put(key, check(i+1,s,openLeftPs+1));
            return cache.get(key);
        } else if (c==')') {
            if(openLeftPs<1) {
                return false;
            }
            cache.put(key, check(i+1,s,openLeftPs-1));
            return cache.get(key);
        } else {//c=='*'
            //it can act as an open,close, or nothing 
            cache.put(key, check(i+1,s,openLeftPs+1)  //open
                    ||
                    check(i+1,s,openLeftPs-1) //close 
                    ||
                    check(i+1,s,openLeftPs)); //empty string);
            return cache.get(key);
        }
    }
}
