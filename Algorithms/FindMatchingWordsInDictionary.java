// Find all words [A-Z] in a dictionary (about 1M words) that are made of 
// a subset (in any order) of the chars in the input parameter [A-Z].
// ex: input "ACRAT" (10 to 20 chars, up to 30 worst case)
// matching words: "A", "CAR", "ACA", "ART", "RAC"
// non-matching words: "BAR", “AAA"

import java.util.*;

class FindMatchingWordsInDictionary{
	
	public static class FBTrie {
        char key;
        FBTrie[] children;
        boolean fullWord;
        
        public FBTrie(char key){
            this.key = key;
            children = new FBTrie[26];
            fullWord = false;
        }

        public void insert(FBTrie root, String s){
            char[] array = s.toCharArray();
            for(int i=0; i<array.length;i++){
                if(root.children[array[i]-'a'] == null){
                    root.children[array[i]-'a'] = new FBTrie(array[i]);;
                }
                root = root.children[array[i]-'a'];
            }
            root.fullWord = true;
        }

        public void searchWord(FBTrie root, int[]output, int[] input, int index, char[] result){
            if(root == null)
                return;
            for(FBTrie child : root.children){
                if(child!=null){
                    result[index] = child.key; 
                    if(input[child.key-'a']==0)
                        continue;
                    if(output[child.key-'a']<input[child.key-'a']){
                        output[child.key-'a']++;
                        searchWord(child, output, input, index+1, result);        
                        output[child.key-'a']--;
                    }
                }
            }
            if(root.fullWord){
                System.out.println(String.valueOf(result, 0, index));
                return;
            }
        }
    }

	public static void main(String[] args){
        String[] dict = {"a", "car", "aca", "art", "rac", "bar", "aaa"};
        FBTrie root = new FBTrie('\0');
        for(String s: dict) root.insert(root, s);
        char[] result = new char[256];
        String s = "acart";
        int[] input = new int[26];
        for(char c: s.toCharArray()){
            input[c-'a']++;
        }
        int[] output = new int[26];
        root.searchWord(root, output, input, 0, result);
	}	

}