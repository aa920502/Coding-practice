// In an array, find  4 indexes such that a[w] + a[x] = a[y] + a[z]

	
public class FindAPlusBEqualsToCPlusD {
	public static int[] solve2(int[] nums) {
		if (nums == null || nums.length < 4) {
			return new int[]{-1, -1, -1, -1};
		}
		boolean[] used = new boolean[nums.length];
		for (int i = 0; i < nums.length-1; i++) {
			used[i] = true;
			for (int j = i + 1; j < nums.length; j++) {
				used[j] = true;
				int[] sum = twoSum(nums, nums[i] + nums[j], used);
				if (sum[0] == -1) {
					used[j] = false;
					continue;
				}
				else {
					int[] ret = new int[]{i, j, sum[0], sum[1]};
					Arrays.sort(ret);
					return ret;
				}
			}
			used[i] = false;
		}
		return new int[]{-1, -1, -1, -1};
	}

	//O(n)
	public static int[] twoSum(int[] numbers, int sum, int[] used){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] result = new int[]{-1,-1};
		for(int i =0; i<numbers.length; i++){
			if(used[i]) continue;
			else{
				if (map.containsKey(numbers[i])) {
					int index = map.get(numbers[i]);
					result[0] = index ;
					result[1] = i;
					break;
				} else {
					map.put(target - numbers[i], i);
				}
			}
		}
		return result;
	}
}