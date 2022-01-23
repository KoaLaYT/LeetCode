package _20220123_ImplementTries;

public class Trie {
    private final TrieNode root = new TrieNode();

    public Trie() {
    }

    public void insert(String word) {
        if (word == null || word.isBlank()) {
            return;
        }

        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (currentNode.nodes[index] == null) {
                currentNode.nodes[index] = new TrieNode();
            }
            currentNode = currentNode.nodes[index];
        }
        currentNode.isWord = true;
    }

    public boolean search(String word) {
        if (word == null || word.isBlank()) {
            return false;
        }

        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode next = currentNode.nodes[word.charAt(i) - 'a'];
            if (next == null) {
                return false;
            }
            currentNode = next;
        }
        return currentNode.isWord;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.isBlank()) {
            return false;
        }

        TrieNode currentNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            TrieNode next = currentNode.nodes[prefix.charAt(i) - 'a'];
            if (next == null) {
                return false;
            }
            currentNode = next;
        }
        return true;
    }

    private static class TrieNode {
        private final TrieNode[] nodes = new TrieNode[26];
        private boolean isWord = false;
    }
}
