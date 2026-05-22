    class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean isWord = false;
    }

class PrefixTree {
    Node root;

    public PrefixTree() {
         this.root = new Node();
    }

    public void insert(String word) {
        Node node = this.root;

        for (char ch : word.toCharArray()) {
            node.children.putIfAbsent(ch, new Node());
            node = node.children.get(ch);
        }

        node.isWord = true;
    }

    public boolean search(String word) {
        Node node = root;

        for (char ch : word.toCharArray()) {
            if (node.children.containsKey(ch)) {
                node = node.children.get(ch);
            } else {
                return false;
            }
        }

        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        Node node = root;

        for (char ch : prefix.toCharArray()) {
            if (node.children.containsKey(ch)) {
                node = node.children.get(ch);
            } else {
                return false;
            }
        }

        return true;
    }
}
