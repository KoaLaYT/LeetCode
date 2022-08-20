package _20220820_DesignAddAndSearchWordsDataStructure;

public class WordDictionary {

    private final Trie root;

    public WordDictionary() {
        this.root = new Trie();
    }

    public void addWord(String word) {
        Trie node = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) {
                node.children[i] = new Trie();
            }
            node = node.children[i];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        return search(root, word.toCharArray(), 0);
    }

    private boolean search(Trie node, char[] word, int i) {
        if (i >= word.length) {
            return node.isWord;
        }

        if (word[i] == '.') {
            for (Trie child : node.children) {
                if (child != null) {
                    boolean found = search(child, word, i + 1);
                    if (found) {
                        return true;
                    }
                }
            }
        } else {
            int childIndex = word[i] - 'a';
            if (node.children[childIndex] != null) {
                return search(node.children[childIndex], word, i + 1);
            }
        }

        return false;
    }

    private static class Trie {
        private final Trie[] children;
        private boolean isWord;

        Trie() {
            this.children = new Trie[26];
            this.isWord = false;
        }
    }

}
