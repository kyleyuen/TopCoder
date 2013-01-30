package srm551;

import java.util.ArrayList;
import java.util.HashMap;

public class ColorfulChocolates {
	public int maximumSpread(String chocolates, int maxSwaps) {
		HashMap<Character, ArrayList<Integer>> color = new HashMap<Character, ArrayList<Integer>>();
		for (int i = 0; i < chocolates.length(); ++i) {
			if (!color.containsKey(chocolates.charAt(i))) {
				color.put(chocolates.charAt(i), new ArrayList<Integer>());
			}
			color.get(chocolates.charAt(i)).add(i);
		}
		
		int result = 1;
		for (Character c : color.keySet()) {
			ArrayList<Integer> indices = color.get(c);
			int swapNum = calculate(indices, maxSwaps);
			if (result < swapNum) {
				result = swapNum;
			}
		}
		return result;
	}

	private int calculate(ArrayList<Integer> indices, int maxSwaps) {
		// TODO Auto-generated method stub
		int result = 1;
		for (int i = 0; i < indices.size(); ++i) {
			ArrayList<Integer> temp = new ArrayList<Integer>(indices);
			temp.remove(indices.get(i));
			
			int start = indices.get(i);
			int end = indices.get(i);
			int swaps = 0;
			while (temp.size() > 0) {
				int mark = 0;
				int minDistance = Math.abs(temp.get(mark) - indices.get(i)) - 1;
				for (int j = 0; j < temp.size(); ++j) {
					int distance = Math.min(Math.abs(temp.get(j) - start), Math.abs(temp.get(j) - end)) - 1;
					if (minDistance > distance) {
						mark = j;
						minDistance = distance;
					}
				}
				
				if (temp.get(mark) > indices.get(i)) {
					++end;
				}
				else {
					--start;
				}
				
				swaps += minDistance;
				if (swaps > maxSwaps) {
					break;
				}
				else {
					temp.remove(mark);
				}
			}
			
			int counter = indices.size() - temp.size();
			if (result < counter) {
				result = counter;
			}
		}
		return result;
	}
}
