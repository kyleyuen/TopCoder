package srm570;

import java.util.HashMap;

public class Chopsticks {
	public int getmax(int[] length) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < length.length; ++i) {
			if (map.containsKey(length[i])) {
				int value = map.get(length[i]);
				map.put(length[i], value + 1); 
			}
			else {
				map.put(length[i], 1);
			}
		}
		
		int result = 0;
		for (Integer key : map.keySet()) {
			result += map.get(key) / 2;
		}
		return result;
	}
}
