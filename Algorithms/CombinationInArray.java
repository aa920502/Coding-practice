// 一个array里面只有0-9的digits, 有一个target， 
//判断是否存在一种组合可以等于target。eg: [6,3,1,0,5]  target=78,这个return True. 63+10+5 = 78 如果target= 636 return True. 631+0+5 = 636

class CombinationInArray{
	public boolean getCombinations(int[] array, int target) {
		return combinations(array, target, 0, 0);
	}
	//Backtracking
	public boolean combinations(int[] array, int target, int prev, int index) {
		if (index == array.length && prev == target) {
			return true;
		} else if (index == array.length) {
			return false;
		}

		for (int i=index; i<array.length; i++) {
			if (array[index] == 0 && i > index) {
				//no numbers starting from 0
				break;
			}

			int curr = generate(array, index, i);
			if (combinations(array, target, prev+curr, i+1)) {
				return true;
			}
		}
		return false;
	}

	private int generate(int[] array, int start, int end) {
		int num = 0;
		for (int i=start; i<=end; i++) {
			num = num*10 + array[i];
		}
		return num;
	}	
}