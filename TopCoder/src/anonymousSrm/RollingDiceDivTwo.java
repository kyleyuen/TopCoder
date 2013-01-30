package anonymousSrm;

import java.util.Arrays;

public class RollingDiceDivTwo {
	public int minimumFaces(String[] rolls) {
		int length = rolls[0].length();
		char[] array = new char[length];
		Arrays.fill(array, '1');
		
		for (int i = 0; i < rolls.length; ++i) {
			char[] temp = rolls[i].toCharArray();
			Arrays.sort(temp);
			for (int j = 0; j < length; ++j) {
				if (array[j] < temp[j]) {
					array[j] = temp[j];
				}
			}
		}
		
		int result = 0;
		for (int i = 0; i < length; ++i) {
			result += array[i] - '0';
		}
		return result;
	}
}
