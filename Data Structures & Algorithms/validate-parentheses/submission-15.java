class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> leftToRight = new HashMap<>();
        leftToRight.put('(', ')');
        leftToRight.put('{', '}');
        leftToRight.put('[', ']');

        Stack<Character> stack = new Stack<>();

        stack.push(s.charAt(0));

        int index = 1;

        while (index <s.length()) {
            char bracket = s.charAt(index);
            if (leftToRight.containsKey(bracket)) {
                //opening, add to stack
                stack.push(bracket);
            } else if (leftToRight.containsValue(bracket)) {
                //closing, pop stack and check 
                if (stack.size()==0) {
                    return false;
                }
                char maybeOpening = stack.pop();
                if (leftToRight.getOrDefault(maybeOpening, ' ') != bracket) {
                    return false;
                }
            }
            index++;
        }

        return stack.isEmpty();
    }
}
