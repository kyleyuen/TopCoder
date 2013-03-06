package anonymousSrm;

public class FoxAndKgram {
	public int maxK(int[] len) {
		int limit = 50;
		int[] counter = new int[limit + 1];
		for (int i = 0; i < len.length; ++i) {
			++counter[len[i]];
		}
		
		int result = 0;
		for (int i = 1; i <= limit; ++i) {
			if (available(counter, i)) {
				result = i;
			}
		}
		return result;
	}

	public boolean available(int[] counter, int length) {
		// TODO Auto-generated method stub
		int result = counter[length];
		for (int i = 1; i + i < length - 1; ++i) {
			result += Math.min(counter[i], counter[length - i - 1]);
		}
		if ((length - 1) % 2 == 0) {
			result += counter[(length - 1) / 2] / 2;
		}
		return result >= length;
	}
}
