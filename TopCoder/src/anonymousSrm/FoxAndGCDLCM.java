package anonymousSrm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FoxAndGCDLCM {
	Long result = Long.MAX_VALUE;
	
	public long get(long G, long L) {
		if (L % G != 0) {
			return -1;
		}
		long differ = L / G;
		
		Map<Long, Integer> factors = getFactor(differ);
		ArrayList<Long> distinctFactor = getDistinctFactor(factors);
		
		recurse(distinctFactor, 0, 1, differ);
		return result * G;
	}

	private void recurse(ArrayList<Long> distinctFactor, int index, long value, long differ) {
		// TODO Auto-generated method stub
		if (index == distinctFactor.size()) {
			if (result > value + differ / value) {
				result = value + differ / value;
			}
			return;
		}
		
		recurse(distinctFactor, index + 1, value * distinctFactor.get(index), differ);
		recurse(distinctFactor, index + 1, value, differ);
	}

	private ArrayList<Long> getDistinctFactor(Map<Long, Integer> factors) {
		// TODO Auto-generated method stub
		ArrayList<Long> distinctFactor = new ArrayList<Long>();
		for (Long factor : factors.keySet()) {
			distinctFactor.add((long) Math.pow(factor, factors.get(factor)));
		}
		return distinctFactor;
	}

	private Map<Long, Integer> getFactor(long differ) {
		// TODO Auto-generated method stub
		HashMap<Long, Integer> factors = new HashMap<Long, Integer>();
		long divisor = 2;
		while (differ != 1) {
			while (differ % divisor == 0) {
				differ /= divisor;
				if (factors.get(divisor) == null) {
					factors.put(divisor, 1);
				}
				else {
					factors.put(divisor, factors.get(divisor) + 1);
				}
			}
			++divisor;
		}
		return factors;
	}
	
}
