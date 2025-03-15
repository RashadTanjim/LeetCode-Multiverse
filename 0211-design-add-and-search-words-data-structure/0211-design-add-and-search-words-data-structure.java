public class TrieNode {
    TrieNode[] children;
    public boolean isWord;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.isWord = false;
    }
}

class WordDictionary {

    private final TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    // Add a word to the Trie
    public void addWord(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a'; // Convert char to index (0 to 25)
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isWord = true;
    }

    // Search a word with support for '.'
    public boolean search(String word) {
        return dfsSearch(word, 0, root);
    }

    private boolean dfsSearch(String word, int index, TrieNode node) {
        if (node == null)
            return false;
        if (index == word.length())
            return node.isWord;

        char c = word.charAt(index);
        if (c == '.') {

            // Wildcard case: Try all 26 children
            for (TrieNode child : node.children) {
                if (child != null && dfsSearch(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            // Regular character lookup
            int charIndex = c - 'a';
            return dfsSearch(word, index + 1, node.children[charIndex]);
        }
    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */