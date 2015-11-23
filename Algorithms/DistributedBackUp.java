import java.util.*;
import java.io.*;

// 题目：

// 输入：第一行是一个0-999999之间的整数，代表数据中心（data center）的数量。
// 接着的每一行分别是一个数据中心，每一行最先是一个0-299的整数代表该数据中心的数据组（data sets）. 
// 然后就是以空格分开的数据。数据都是1-999999之间的整数。每一行最多999个字符长。

// 输出：

// 要求输出分布式备份的步骤，将数据在数据中心间互相拷贝，最后使得所有数据中心都有所有的数据。
// 打印出的步骤的格式是： <data-set-id> <from> <to>

//  <data-set-id> 就是所要拷贝的数据， <from> 是该数据所在数据中心的索引， <to>是即将拷贝过去的数据中心的索引

// 当步骤结束后，打印“done”。

// 能实现分布式备份的步骤往往不是唯一的，打印出任何正确地步骤均可。


// 约束:

// 输入必须来自stdin，输出必输到stdout。可以假设输入是有效的。

// 例如：

// 输入:
// 3
// 5 1 3 4 5 7
// 2 1 3
// 1 2


// 一种正确地输出:
// 2 3 2
// 2 3 1
// 1 1 3
// 4 1 2
// 5 1 3
// 5 3 2
// 4 2 3
// 3 1 3
// 7 1 2
// 7 1 3
// done


public class DistributedBackUp {
	public static void main(String args[]) throws Exception {
		List<Set<Integer>> inputsets = new ArrayList<Set<Integer>>();
		Set<Integer> inputdata = new HashSet<Integer>();//all unique data sets
		Map<Integer, Integer> reversedIndex = new HashMap<Integer, Integer>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		//First line: get number of data centers
		String line = br.readLine();
		int num = Integer.parseInt(line);

		for (int i = 0; i < num; i++) {
			String[] data = br.readLine().split(" ");//Split by space
			HashSet<Integer> hs = new HashSet<Integer>(data.length);
			inputsets.add(hs);
			if (data.length == 1) {
				continue;
			}
			// how many data sets does this data center have?
			int size = Integer.parseInt(data[0]);
			for (int j = 1; j < size+1; j++) {
				int tmp = Integer.parseInt(data[j]);
				hs.add(tmp);
				inputdata.add(tmp);
				if (!reversedIndex.containsKey(tmp)) {
					reversedIndex.put(tmp, i + 1);
				}
			}
		}

		// Compare and fill in
		for (int i = 0; i < inputsets.size(); i++) {
			Set<Integer> s = inputsets.get(i);
			for (Integer j : inputdata) {
				if (!s.contains(j)) {
					System.out.println(j + " " + reversedIndex.get(j) + " " + (i + 1));
				}
			}
		}
		//done
		System.out.println("done");
	}
}