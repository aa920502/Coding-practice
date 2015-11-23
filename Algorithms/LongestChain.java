import java.util.*;

// 给一个字符串数组, 以任意一个单词开始，删除一个字母 ，如果形成的新字符串还在数组的单词堆里面，则是合法的， chain长度增加1.
// 然后继续往下删，每删一个则长度增加1.
// 举些例子吧：(a, abcd, bcd, abd, cd, c)：
// abcd 删除一个字母可以变成 bcd ， abd， acd，abc。但是只有bcd， acd 可以往下走，所以下面只要考虑这两个。 
// bcd 可以变成cd 再变成c。 但是abd删除一个单词不能变成数组的一个单词。所以停止。

// 返回最长的chain含有单词的数目： abcd-- bcd -- cd -- c,返回4.

class LongestChain{

    // Sort array in descending order of word length
    static class comp implements Comparator<String> {
      public int compare(String o1, String o2) {
        return Integer.compare(o2.length(), o1.length());
      }
    }
	
	static int longest_chain(String[] w) {
        HashSet<String> dict = new HashSet<String>();  
        // remeber the word and its relative longest chain.
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        Arrays.sort(w,new comp());
        //Add all words
        for (int i = 0; i < w.length; i++) {
            dict.add(w[i]);
        }

        int longest = 0;
        //Start from longest word
        for (int i = 0; i < w.length; i++) {
            int len = helper(w[i], dict, map, 0) + 1;  // add itself
            map.put(w[i], len);
            longest = Math.max(longest, len);
        }
        return longest;
    }


    static int helper(String word, HashSet<String> dict, HashMap<String, Integer> map, int length) {
        for (int i = 0; i < word.length(); i++) {
            StringBuilder s = new StringBuilder(word);
            s = s.deleteCharAt(i);
            String newWord = s.toString();
            if (dict.contains(newWord)){ 
                if (newWord.length()==1) return length+1;
                else{
                    if (newWord.length()>1 && map.containsKey(newWord))
                        return map.get(newWord)+length;
                    else 
                        return helper(newWord, dict, map, length+1);
                }
            }
        }
        return 0;
    }
    

    public static void main(String[] args){
        String[] test = new String[]{"a","wwwwwww","bcd","abd","cd","c"};
        System.out.println(longest_chain(test));
    }

}
