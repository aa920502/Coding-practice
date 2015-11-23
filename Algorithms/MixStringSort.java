import java.util.*;
import java.io.*;
// 题目：

// 从stdin读入一行String，String中同时包括单词和数字，以空格分开。需要将输入进行排序，
// 要求：（1）字母和数字分别顺序排序（2）输入中原本是字母/数字的地方依然是字母/数字。

// 比如输入：d 3 c 2 1 a 输出为 a 1 c 2 3 d 

//         输入：add 6 abb at 输出为 abb 6 add at


// 思路：

// 由于单词元素和数字元素是以空格分开的，可以将输入的String解析成单个输入元素的list。
// 然后一一判断这些元素是不是数字，如果是的话，标记所在位置，并将该元素加到一个新的叫integers的list中，
// 再将单词加到另一个叫words的list中。分别对这两个list排序后根据之前标记的位置把排序好的值重新填回去。


public class MixStringSort {
	public static void main(String args[]) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		//读取输入字符串并用sortString方法来处理
		while ((line = reader.readLine()) != null) {
			new MixStringSort().sortString(line);
		}
	}

	public void sortString(String line) {
		ArrayList<Integer> integers = new ArrayList<Integer>();//存数字
		ArrayList<String> words = new ArrayList<String>();//存单词
		int index_words = 0, index_integers = 0;
        
		//split输入的String存到list里
		String[] stringlist = line.split(" ");
        
		//遍历stringlist把数字加到integers的ArrayList里，把单词加到words
		for (int i = 0; i < stringlist.length; i++) {
			if (isNumeric(stringlist[i])) {
				integers.add(Integer.parseInt(stringlist[i]));
				stringlist[i] = "0";//把是数字的地方统一标记为“0”
			} else {
				words.add(stringlist[i]);
				stringlist[i] = "1";//把是单词的地方统一标记为“1”
			}
		}
		
		//利用库分别对数字和字母排序
		Collections.sort(integers);
		Collections.sort(words);

		for (int i = 0; i < stringlist.length; i++) {
			if (stringlist[i] == "0") {//将integers里的数字挨个加到stringlist标记为“0”处
				stringlist[i] = String.valueOf(integers.get(index_integers));
				index_integers++;
			} else {//将words里的单词挨个加到stringlist标记为“1”处
				stringlist[i] = words.get(index_words);
				index_words++;
			}
		}

		//打印结果
		for (int i = 0; i < stringlist.length-1; i++) {
			System.out.print(stringlist[i]+" ");
		}
        System.out.print(stringlist[stringlist.length-1]);
	}

	//判断输入字符的内容是否是数字
	public static boolean isNumeric(String s) {
		 for (char c : s.toCharArray()){
	        if (!Character.isDigit(c)) return false;
	    }
	    return true;
	}
}
