package _20220728_NumberOfStringPrefix;

public class Solution {

    public int number_of_string_prefix(String[] s, String a) {
        if (a == null || s == null) {
            return 0;
        }

        if (a.length() == 0 || s.length == 0) {
            return 0;
        }

        Trie root = Trie.buildTrie(s);
        return numberOfStringPrefix(root, a.toCharArray());
    }

    public int numberOfStringPrefix(Trie trie, char[] a) {
        Trie node = trie;
        for (char c : a) {
            Trie child = node.children[c - 'a'];
            if (child == null) {
                return 0;
            }
            node = child;
        }
        return node.value;
    }

    private static class Trie {
        int value = 0;
        Trie[] children = new Trie[26];

        static Trie buildTrie(String[] s) {
            Trie root = new Trie();

            for (String str : s) {
                Trie trie = root;
                for (char c : str.toCharArray()) {
                    if (trie.children[c - 'a'] == null) {
                        trie.children[c - 'a'] = new Trie();
                    }
                    trie = trie.children[c - 'a'];
                    trie.value += 1;
                }
            }

            return root;
        }
    }

}
