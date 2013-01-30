package srm568;

public class BallsSeparating {
	public int minOperations(int[] red, int[] green, int[] blue) {
		int n = red.length;
		if (n < 3) {
			return -1;
		}
		
		int[] state = new int[n];
		for (int i = 0; i < n; ++i) {
			if (red[i] > green[i]) {
				state[i] = 1;
			}
			else {
				state[i] = 2;
			}
			if (blue[i] > Math.max(red[i], green[i])) {
				state[i] = 3;
			}
		}
		
		while (true) {
			int result = checkValid(state);
			if (result == 0) {
				break;
			}
			else {
				fix(state, result, red, green, blue);
			}
		}
		
		int result = 0;
		for (int i = 0; i < n; ++i) {
			switch (state[i]) {
			case 1:
				result += green[i] + blue[i];
				break;
			case 2:
				result += red[i] + blue[i];
				break;
			case 3:
				result += red[i] + green[i];
				break;
			}
		}
		return result;
	}

	private void fix(int[] state, int result, int[] red, int[] green, int[] blue) {
		// TODO Auto-generated method stub
		boolean[] fixed = new boolean[4];
		int[] counter = new int[4];
		for (int i = 0; i < state.length; ++i) {
			++counter[state[i]];
		}
		for (int i = 1; i <= 3; ++i) {
			if (counter[i] == 1) {
				fixed[i] = true;
			}
		}
		
		int index = 0;
		int value = Integer.MAX_VALUE;
		for (int i = 0; i < state.length; ++i) {
			if (fixed[state[i]]) {
				continue;
			}
			for (int j = 1; j <= 3; ++j) {
				if (j != state[i]) {
					continue;
				}
				
				int temp;
				if (result == 1) {
					temp = red[i];
				}
				else if (result == 2) {
					temp =green[i];
				}
				else {
					temp = blue[i];
				}
				
				switch (j) {
				case 1:
					if (value > red[i] - temp) {
						value = red[i] - temp;
						index = i;
					}
					break;
				case 2:
					if (value > green[i] - temp) {
						value = green[i] - temp;
						index = i;
					}
					break;
				case 3:
					if (value > blue[i] - temp) {
						value = blue[i] - temp;
						index = i;
					}
					break;
				}
			}
		}
		state[index] = result;
	}

	private int checkValid(int[] state) {
		// TODO Auto-generated method stub
		boolean[] flag = new boolean[4];
		for (int i = 0; i < state.length; ++i) {
			flag[state[i]] = true;
		}
		for (int i = 1; i <= 3; ++i) {
			if (!flag[i]) {
				return i;
			}
		}
		return 0;
	}
}
