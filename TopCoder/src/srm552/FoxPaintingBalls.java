package srm552;

public class FoxPaintingBalls {
	public long theMax(long R, long G, long B, int N) {
		long total = 0;
		for (int i = 1; i <= N; ++i) {
			total += i;
		}
		
		long less = total / 3;
		long more = less;
		if (N % 3 == 1) {			
			more = less + 1;
		}
		
		long result = (R + G + B) / (more + 2 * less);
		return result;
	}
}
