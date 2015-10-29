// 给一个0/1数组R代表一条河，0代表水，1代表石头。起始位置R[0]等于1，
// 初速度为1. 每一步可以选择以当前速度移动，或者当前速度加1再移动。只能停留在石头上。问最少几步可以跳完整条河流。

// 给定数组为R=[1,1,1,0,1,1,0,0]，最少3步能过河：
// 第一步先提速到2，再跳到R[2]；
// 第二步先提速到3，再跳到R[5]；
// 第三步保持速度3，跳出数组范围，成功过河。


class JumpRiver{

	static int res = Integer.MAX_VALUE;
	public int Jump(int[] R, int n){
		helper(R,n,0,1,0);
		return res;
	}

	public void helper(int[] R, int size, int pos, int speed, int step){
		if(pos>= size){
			res = Math.min(res,step);
			return;
		}
		if(R[pos]==0) return;
		// R[pos] = 1
		helper(R,size,pos+speed,speed,step+1);
		helper(R,size,pos+speed+1,speed+1,step+1);
	}

	public static void main(String[] args){
		int[] R = new int[]{1,1,1,0,1,1,0,0};
		JumpRiver j = new JumpRiver();
		System.out.println(j.Jump(R,8));
	}
}