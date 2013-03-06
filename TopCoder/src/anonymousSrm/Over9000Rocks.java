package anonymousSrm;

import java.util.ArrayList;
import java.util.Collections;

public class Over9000Rocks {
	
	private class Pair implements Comparable<Pair> {
		int lower;
		int upper;
		
		public Pair(int lower, int upper) {
			this.lower = lower;
			this.upper = upper;
		}

		@Override
		public int compareTo(Pair arg0) {
			// TODO Auto-generated method stub
			return this.lower - arg0.lower;
		}
	}
	
	public int countPossibilities(int[] lowerBound, int[] upperBound) {
		ArrayList<Pair> pairs = generatePairs(lowerBound, upperBound);
		Collections.sort(pairs);
		
		int result = 0;
		int limit = 9000;	
		for (Pair pair : pairs) {
			if (pair.lower <= limit && limit < pair.upper) {
				result += pair.upper - limit;
				limit = pair.upper;
			}
			if (limit < pair.lower) {
				result += pair.upper - pair.lower + 1;
				limit = pair.upper;
			}
		}
		return result;
	}
	
	private ArrayList<Pair> generatePairs(int[] lowerBound, int[] upperBound) {
		// TODO Auto-generated method stub
		ArrayList<Pair> result = new ArrayList<Pair>();
		int n = lowerBound.length;
		doGeneratePairs(lowerBound, upperBound, 0, n, 0, 0, result);
		return result;
	}

	private void doGeneratePairs(int[] lowerBound, int[] upperBound, int i,
			int n, int lower, int upper, ArrayList<Pair> result) {
		// TODO Auto-generated method stub
		if (i == n) {
			result.add(new Pair(lower, upper));
		}
		else {
			doGeneratePairs(lowerBound, upperBound, i + 1, n, lower, upper, result);
			doGeneratePairs(lowerBound, upperBound, i + 1, n, lower + lowerBound[i], upper + upperBound[i], result);
		}
	}
	
}
