class WordDictionary {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
        }

        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode curr) {

        if (index == word.length()) {
            return curr.isEnd;
        }

        char ch = word.charAt(index);

        // Normal character
        if (ch != '.') {
            int i = ch - 'a';

            if (curr.children[i] == null) {
                return false;
            }

            return dfs(word, index + 1, curr.children[i]);
        }

        // '.' means any character
        for (TrieNode child : curr.children) {

            if (child != null && dfs(word, index + 1, child)) {
                return true;
            }
        }

        return false;
    }
}