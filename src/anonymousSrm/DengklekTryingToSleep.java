package anonymousSrm;

public class DengklekTryingToSleep {
	public int minDucks(int[] ducks) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < ducks.length; ++i) {
			if (max < ducks[i]) {
				max = ducks[i];
			}
			if (min > ducks[i]) {
				min = ducks[i];
			}
		}
		return max - min - ducks.length + 1;
	}
}
