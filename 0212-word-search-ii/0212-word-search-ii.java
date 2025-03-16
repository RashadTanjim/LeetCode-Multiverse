import java.util.*;

class Solution {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null; 
    }

    private final TrieNode root = new TrieNode();
    private final List<String> result = new ArrayList<>();

    private void insertWord(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.word = word; 
    }

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            insertWord(word);
        }

        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node) {
        char c = board[i][j];

        if (c == '#' || node.children[c - 'a'] == null)
            return;

        node = node.children[c - 'a'];

        if (node.word != null) {
            result.add(node.word);
            node.word = null; // Avoid duplicate results
        }

        board[i][j] = '#';
    
        if (i > 0)
            dfs(board, i - 1, j, node); // Up
        if (i < board.length - 1)
            dfs(board, i + 1, j, node); // Down
        if (j > 0)
            dfs(board, i, j - 1, node); // Left
        if (j < board[0].length - 1)
            dfs(board, i, j + 1, node); // Right

        // Step 7: Restore cell
        board[i][j] = c;
    }
}
