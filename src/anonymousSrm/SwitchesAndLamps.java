package anonymousSrm;

import java.util.Arrays;

public class SwitchesAndLamps {
	public int theMin(String[] switches, String[] lamps) {
		int m = switches.length;
		int n = switches[0].length();
		
		boolean[] state = new boolean[n];
		Arrays.fill(state, false);
		int remainLamps = n;
		int maxGroup = 0;
		for (int i = 0; i < n; ++i) {
			if (state[i]) {
				continue;
			}
			
			int switchCounter = 0;
			int lampCounter = 0;
			for (int j = 0; j < n; ++j) {
				boolean judge = true;
				for (int k = 0; k < m; ++k) {
					if (switches[k].charAt(i) != switches[k].charAt(j)) {
						judge = false;
						break;
					}
				}
				if (judge) {
					state[j] = true;
					++switchCounter;
				}
			}
			
			for (int j = 0; j < n; ++j) {
				boolean judge = true;
				for (int k = 0; k < m; ++k) {
					if (switches[k].charAt(i) != lamps[k].charAt(j)) {
						judge = false;
						break;
					}
				}
				if (judge) {
					--remainLamps;
					++lampCounter;
				}
			}
			
			if (switchCounter == lampCounter) {
				maxGroup = Math.max(maxGroup, switchCounter);
			}
			else {
				return -1;
			}
		}
	
		if (remainLamps > 0) {
			return -1;
		}
		else {
			int result = 0;
			while (maxGroup > 1) {
				maxGroup = (maxGroup + 1) / 2;
				++result;
			}
			return result;
		}
	}
}
