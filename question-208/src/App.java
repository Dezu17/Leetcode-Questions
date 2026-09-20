public class App {
    public static void main(String[] args) throws Exception {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));

        trie = new Trie();
        trie.insert("dog");
        System.out.println(trie.search("dog"));
        System.out.println(trie.search("do"));
        System.out.println(trie.startsWith("do"));
        trie.insert("do");
        System.out.println(trie.search("do"));
    }
}

class Trie {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean endOfWord;
    }

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode currentNode = root;
        for (char currentCharacter : word.toCharArray()) {
            if (currentNode.children[currentCharacter - 'a'] == null) {
                currentNode.children[currentCharacter - 'a'] = new TrieNode();
            }
            currentNode = currentNode.children[currentCharacter - 'a'];
        }
        currentNode.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode currentNode = root;
        for (char currentCharacter : word.toCharArray()) {
            if (currentNode.children[currentCharacter - 'a'] == null)
                return false;
            currentNode = currentNode.children[currentCharacter - 'a'];
        }
        return currentNode.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode currentNode = root;
        for (char currentCharacter : prefix.toCharArray()) {
            if (currentNode.children[currentCharacter - 'a'] == null)
                return false;
            currentNode = currentNode.children[currentCharacter - 'a'];
        }
        return true;
    }
}