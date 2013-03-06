package anonymousSrm;

import java.util.Arrays;

public class GogoXBallsAndBinsEasy {
	public int solve(int[] T) {
		int result = 0;
		boolean[] state = new boolean[T.length];
		Arrays.fill(state, true);
		for (int i = 0; i < T.length / 2; ++i) {
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int maxIndex = 0;
			int minIndex = 0;
			
			for (int j = 0; j < T.length; ++j) {
				if (state[j]) {
					if (max < T[j]) {
						max = T[j];
						maxIndex = j;
					}
					if (min > T[j]) {
						min = T[j];
						minIndex = j;
					}
				}
			}
			
			state[maxIndex] = false;
			state[minIndex] = false;
			result += max - min;
		}
		return result;
	}
}
