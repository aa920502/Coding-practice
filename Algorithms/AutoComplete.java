import java.io.*;
import java.util.*;

/*
 * When typing on a phone keyboard, the OS should try to minimize the number of keystrokes required for typing.  
 To achieve this goal, your phone company is going to put together a dictionary of the common words that a user may type. 
 The goal is to reduce the average number of keystrokes needed to type words that are in the dictionary. During the typing of a word, 
 whenever the following letter is uniquely determined, the cellphone system will input it automatically, without the need for a keystroke. 
 To be more precise, the behavior of the cellphone system will be determined by the following rules:
The system never guesses the first letter of a word, so the first letter always has to be input manually by pressing the corresponding key.

If a non-empty succession of letters c1c2...cn has been input, and there is a letter c such that every word in the dictionary which starts with
 c1c2...cn also starts with c1c2...cnc, then the system inputs c automatically, without the need of a keystroke. Otherwise, the system waits for the user.

For instance, if the dictionary is composed of the words `hello', `hell', `heaven' and `goodbye', and the user presses `h', the system will input `e' automatically,
 because every word which starts with `h' also starts with `he'. However, since there are words that start with `hel' and with `hea', the system now needs to wait 
 for the user. If the user then presses `l', obtaining the partial word `hel', the system will input a second `l' automatically. When it has `hell' as input, 
 the system cannot guess, because it is possible that the word is over, or it is also possible that the user may want to press `o' to get `hello'. In this fashion, 
 to type the word `hello' the user needs three keystrokes, `hell' requires two, and `heaven' also requires two, because when the current input is `hea' the system 
 can automatically input the remainder of the word by repeatedly applying the second rule. Similarly, the word `goodbye' needs just one keystroke, 
 because after pressing the initial `g' the system will automatically fill in the entire word.  If the user enters a word that isn’t in the dictionary, 
 the dictionary will be used to predict input as much as possible.  For instance, `hellfire' needs six keystrokes (h, l, f, i, r, e).
Your task is, given a dictionary and a list of words to be typed, to calculate the number of keystrokes required to type each input word.
 */

class AutoComplete {
  private static final String[] DICTIONARY = new String[] {"hell", "hello", "heaven", "goodbye"};
  private static TrieNode root;
  
  public static void main(String[] args) {
    root = new TrieNode();
    for(String str: DICTIONARY) 
      add(str);
    
    for (String word : DICTIONARY) {
      test(word);
    }
    test("hellfire");
    test("hellfire");
    test("taco");
    test("taco");
  }
  
  private static void test(String word) {
    System.out.println(word + ": " + numKeystrokes(word));
  }
  
  private static int numKeystrokes(String word) {
    if(word==null || word.length()==0) return 0;
    
    int keyStroke = 1;
    
    TrieNode t = root;
    char c = word.charAt(0); 
    if(t.next[c-'a']==null){ 
      add(word);
      return word.length();  //"tree"
    }
    
    t = t.next[c-'a'];
    
    for(int i=1; i< word.length(); i++){
      char tmp = word.charAt(i);
      
      
      // If node has only one child and the child is tmp
      if(hasOneChild(t,tmp) && t.isEnd!=true){
        t = t.next[tmp-'a'];
        continue;
      }
      
      else{
        // helloo
        if(t.next[tmp-'a']==null){ 
          keyStroke+=(word.length()-i);
          break;
        }
        else{
          t = t.next[tmp-'a'];
          keyStroke ++;
          continue;
        }
      }
    }
    add(word);
    return keyStroke;
  }
  
  static class TrieNode {
    boolean isEnd;
    public TrieNode[] next;
    public TrieNode(){
      isEnd = false;
      next = new TrieNode[26];
    }
  }
  //Insert a word into trie
  public static void add(String word){
    TrieNode temp = root;
    for(int i=0;i<word.length();i++){
      char c = word.charAt(i);
      if(temp.next[c-'a']==null)
        temp.next[c-'a'] = new TrieNode();
      temp = temp.next[c-'a'];
      
    }
    temp.isEnd = true;
  }
  
        
  // 
  public static boolean hasOneChild(TrieNode node, Character toBeFound){
    int count = 0;
    boolean found = false;
    for(int i=0; i<26;i++){
      if(node.next[i]!=null){
        count++;
      }
    }
    if(node.next[toBeFound-'a']!=null) found=true;
    return count==1 && found;
  }  
}


