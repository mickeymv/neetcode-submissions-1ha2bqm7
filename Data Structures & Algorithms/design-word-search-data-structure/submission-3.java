class Node {
    Map<Character, Node> children = new HashMap<>();
    boolean isWord = false;
}

class WordDictionary {
    Node root;
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node node = root;

        for (char ch : word.toCharArray()) {
            node.children.putIfAbsent(ch, new Node());
            node = node.children.get(ch);
        }

        node.isWord = true;
    }

    public boolean search(String word) {
        return search(this.root, word, 0);
    }

    public boolean search(Node root, String word, int index) {
        Node node = root;

        for (int i = index; i<word.length();i++) {
            char ch = word.charAt(i);
            if (node.children.containsKey(ch)) {
                node = node.children.get(ch);
            } else if (ch == '.') {
                for (Node child : node.children.values()) {
                    if (search(child, word, i+1)) {
                        return true;
                    }
                }
                return false;
            } else {
                return false;
            }
        }

        return node.isWord;
    }
}
