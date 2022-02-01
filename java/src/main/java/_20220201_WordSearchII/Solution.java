package _20220201_WordSearchII;

import java.util.*;

class Solution {

    public List<String> findWords(char[][] board, String[] words) {
        if (board.length == 0 || board[0].length == 0) {
            return Collections.emptyList();
        }

        Set<String> result = new HashSet<>();
        TrieNode root = new TrieNode(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                findWords(board, i, j, root, result);
            }
        }
        return new ArrayList<>(result);
    }

    private void findWords(char[][] board, int i, int j,
                           TrieNode node, Set<String> result) {
        String word = node.getWord();
        if (word != null) {
            result.add(word);
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || board[i][j] == '\0') return;

        char c = board[i][j];
        TrieNode next = node.next(c);
        if (next != null) {
            board[i][j] = '\0';
            findWords(board, i + 1, j, next, result);
            findWords(board, i, j + 1, next, result);
            findWords(board, i - 1, j, next, result);
            findWords(board, i, j - 1, next, result);
            board[i][j] = c;
        }
    }

}
