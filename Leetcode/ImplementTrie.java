// Implement a trie with insert, search, and startsWith methods.

// Note:
// You may assume that all inputs are consist of lowercase letters a-z.

class ImplementTrie{
	
    class TrieNode {
        public boolean endpoint;
        public TrieNode[] next;
        // Initialize your data structure here.
        public TrieNode() {
            endpoint = false;
            next = new TrieNode[26];
        }
    }

    public class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            if(word==null) return;
            TrieNode temp = root;
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                if(temp.next[c-'a']==null){
                    temp.next[c-'a'] = new TrieNode();
                }
                temp = temp.next[c-'a'];
            }
            temp.endpoint = true;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            if(word!=null){
                TrieNode temp = root;
                for(int i=0;i<word.length();i++){
                    if(temp.next[word.charAt(i)-'a']==null) return false;
                    else temp = temp.next[word.charAt(i)-'a'];
                }
                if(temp.endpoint) return true;
            }
            return false;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            if(prefix!=null){
                TrieNode temp = root;
                for(int i=0;i<prefix.length();i++){
                    if(temp.next[prefix.charAt(i)-'a']==null) return false;
                    else temp = temp.next[prefix.charAt(i)-'a'];
                }
                return true;
            }
            return false;
        }
    }

    // Your Trie object will be instantiated and called as such:
    // Trie trie = new Trie();
    // trie.insert("somestring");
    // trie.search("key");

}