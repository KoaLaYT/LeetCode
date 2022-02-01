package _20220201_WordSearchII;

public class TrieNode {

    private TrieNode[] children = new TrieNode[26];
    private String word = null;

    public TrieNode() {
    }

    public TrieNode(String[] words) {
        for (String word : words) {
            TrieNode node = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int slot = c - 'a';
                if (node.children[slot] == null) {
                    node.children[slot] = new TrieNode();
                }
                node = node.children[slot];
            }
            node.word = word;
        }
    }

    public String getWord() {
        return this.word;
    }

    public TrieNode next(char c) {
        return this.children[c - 'a'];
    }

}
