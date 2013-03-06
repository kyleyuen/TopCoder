package srm553;

import java.util.Arrays;

public class SafeRemoval {
	public int removeThem(int[] seq, int k) {
		Arrays.sort(seq);
		int sum = 0;
		for (int j = 0; j < seq.length; ++j) {
			sum += seq[j];
		}
		for (int i = 0; i < k; ++i) {
			boolean judge = false;
			for (int j = 0; j < seq.length; ++j) {
				if ((sum - seq[j]) % 4 != 0 && seq[j] != 0) {
					sum -= seq[j];
					seq[j] = 0;
					judge = true;
					break;
				}
			}
			if (judge == false) {
				return -1;
			}
		}	
		return sum;
	}
}
