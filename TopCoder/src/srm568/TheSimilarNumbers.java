package srm568;

public class TheSimilarNumbers {
	public int find(int lower, int upper) {
		int result = 0;
		while (lower <= upper) {
			++result;
			lower = lower * 10 + 1;
		}
		return result;
	}
}
