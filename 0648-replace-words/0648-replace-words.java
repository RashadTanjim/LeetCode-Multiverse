class Solution {
    
    public String replaceWords(List<String> dictionary, String sentence) {
        
         // Create the Trie root
        TrieNode root = new TrieNode();
        
        // Insert all roots into the Trie
        for (String rootWord : dictionary) {
            insert(root, rootWord);
        }
        
        // Split the sentence into words
        String[] words = sentence.split("\\s+");
        StringBuilder result = new StringBuilder();
        
        // Replace words with their corresponding roots
        for (String word : words) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(searchRoot(root, word));
        }
        
        return result.toString();
    }
    
    
    // TrieNode class to represent each node in the Trie
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null;
    }
    
    // Insert a word into the Trie
    private void insert(TrieNode root, String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.word = word;
    }
    
    // Search for the shortest root for a given word in the Trie
    private String searchRoot(TrieNode root, String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return word; // No root found, return the original word
            }
            node = node.children.get(c);
            if (node.word != null) {
                return node.word; // Return the root if found
            }
        }
        return word; // Return the original word if no root is found
    }
}