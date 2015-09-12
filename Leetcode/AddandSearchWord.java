// Design a data structure that supports the following two operations:

// void addWord(word)
// bool search(word)
// search(word) can search a literal word or a regular expression string containing only letters a-z or .. 
// A . means it can represent any one letter.

// For example:

// addWord("bad")
// addWord("dad")
// addWord("mad")
// search("pad") -> false
// search("bad") -> true
// search(".ad") -> true
// search("b..") -> true
// Note:
// You may assume that all words are consist of lowercase letters a-z.


class AddandSearchWord{

	public class WordDictionary {
	    private TrieNode root;

	    public WordDictionary() {
	        root = new TrieNode();
	    }

	    // Adds a word into the data structure.
	    public void addWord(String word) {
	        if(word!=null){
	            TrieNode tmp = root;
	            for(int i=0;i<word.length();i++){
	                if(tmp.next[word.charAt(i)-'a']==null){
	                    tmp.next[word.charAt(i)-'a'] = new TrieNode();
	                }
	                tmp = tmp.next[word.charAt(i)-'a'];
	            }
	            tmp.endpoint = true;
	        }
	    }

	    // Returns if the word is in the data structure. A word could
	    // contain the dot character '.' to represent any one letter.
	    public boolean search(String word) {
	        return search(word, 0, root);
	    }
	    public boolean search(String word, int index, TrieNode root){
	        if(index == word.length() && root.endpoint == true) return true;
	        if(index == word.length()) return false;
	        // If is '.', search all possibilities
	        if(word.charAt(index)=='.'){
	            for(int i =0;i<26;i++){
	                if(root.next[i]!=null && search(word,index+1,root.next[i])) 
	                    return true;
	            }
	        }
	        else if(root.next[word.charAt(index)-'a']!=null && search(word,index+1,root.next[word.charAt(index)-'a']))
	            return true;
	        
	        return false;
	    }
	}

	class TrieNode {
	    public boolean endpoint;
	    public TrieNode[] next;
	    // Initialize your data structure here.
	    public TrieNode() {
	        endpoint = false;
	        next = new TrieNode[26];
	    }
	}

	// Your WordDictionary object will be instantiated and called as such:
	// WordDictionary wordDictionary = new WordDictionary();
	// wordDictionary.addWord("word");
	// wordDictionary.search("pattern");
}