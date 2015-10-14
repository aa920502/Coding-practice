// 有一个set里有不同的字母{'a', 'b', 'c'}, 
// 有一个整数值K，如果K＝2，输出aa,ab,ac,ba,bb,bc,ca,cb,cc
// follow up:组合中不包含相同字符怎么实现
// follow up++:不用额外空间怎么做

import java.util.*;
class SetNChooseK{

	public void Print1(Character[] set, int k){
		String s = "";
		Arrays.sort(set);
		helper(s,set,k);
	}
	public void helper(String s,Character[] set,int k){
		if(k==0){
			System.out.println(s);
			return;
		}

		for(int i=0;i<set.length;i++){
			String temp = s + set[i];
			helper(temp,set,k-1);
		}
	}

	//Follow up 
	//Use boolean[] used to avoid second calls
	public void Print2(Character[] set, int k){
		String s = "";
		Arrays.sort(set);
		boolean[] used = new boolean[set.length];
		helper2(s,set,k,used);
	}
	public void helper2(String s,Character[] set,int k,boolean[] used){
		if(k==0){
			System.out.println(s);
			return;
		}

		for(int i=0;i<set.length;i++){
			if(used[i]) continue;
			used[i] = true;
			helper2(s + set[i],set,k-1,used);
			used[i] = false;
		}
	}

	//Follow up 2
	// First do n out of k combination, then for each combination result
	// do permutation on it

	public void Print3(Character[] set, int k){
		String s = "";
		Arrays.sort(set);
		Comb(0,set,k,"");
	}
	public void Comb(int index,Character[] set, int k,String s){
		if(k==0){
			Perm(s.toCharArray());
		}
		for(int i = index; i<set.length;i++){
			Comb(i+1,set,k-1,s+set[i]);
		}
	}

    public void Perm(char[] set) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(set);
        backTrack(sb,0,set,set.length);
    }

    void backTrack (StringBuilder sb,int i,char[] set, int k){
        //Permutation completes
        if(i==k){
            System.out.println(sb.toString());
            return;
        }
       //Insert elements in the array by increasing index
        for(int j=0;j<=i;j++){
            sb.insert(j,set[i]);
            backTrack(sb,i+1,set,k);
            sb.deleteCharAt(j);
        }
    }



	public static void main(String[] args){
		SetNChooseK s = new SetNChooseK();
		Character[] set = new Character[]{'b','a','c'};
		s.Print3(set,2);
	}

}