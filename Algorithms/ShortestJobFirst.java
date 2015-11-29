import java.util.Comparator;
import java.util.PriorityQueue;

// Shortest job first (non-preempt) 类似11,但不可打断process所有等候process中
// 优先执行耗时最少的，如多个一样小，遵从FIFO原则
class process {
	int arrTime;
	int exeTime;
	process(int arr, int exe) {
		arrTime = arr;
		exeTime = exe;
	}
}

public class ShortestJobFirst {

	public static class processComp implements Comparator<process>{
		@Override
		public int compare(process p1, process p2) {
			if (p1.exeTime == p2.exeTime)
				return p1.arrTime - p2.arrTime;
			return p1.exeTime - p2.exeTime;
		}
	}

	public static float Solution(int[] req, int[] dur) {
		if (req == null || dur == null || req.length != dur.length)	return 0;
		
		int index = 0, length = req.length;
		int waitTime = 0, curTime = 0;
		
		PriorityQueue<process> pq = new PriorityQueue<process>(new processComp());
		
		while (!pq.isEmpty() || index < length) {
			if (!pq.isEmpty()) {
				process cur = pq.poll();
				waitTime += curTime - cur.arrTime;
				curTime += cur.exeTime;
				while (index < length && curTime >= req[index])
					pq.offer(new process(req[index], dur[index++]));
			}
			else {
				pq.offer(new process(req[index], dur[index]));
				curTime = req[index++];
			}
		}
		return (float) waitTime / length;
	}

	public static void main(String[] args) {
		int[] req = new int[]{0,1,2};
		int[] dur = new int[]{5,4,3};
		System.out.println(Solution(req,dur));
	}
}
