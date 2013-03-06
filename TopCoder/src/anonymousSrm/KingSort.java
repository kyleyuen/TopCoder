package anonymousSrm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class KingSort {
	public String[] getSortedList(String[] kings) {
		Arrays.sort(kings, new MyComparator());
		return kings;
	}
	
	private static class MyComparator implements Comparator<String> {
		private static Map<Character, Integer> numeral;
		static {
			numeral = new HashMap<Character, Integer>();
			numeral.put('I', 1);
			numeral.put('V', 5);
			numeral.put('X', 10);
			numeral.put('L', 50);
		}
		
		public int compare(String lhs, String rhs) {
			String[] left = lhs.split(" ");
			String[] right = rhs.split(" ");
			
			if (left[0].equals(right[0])) {
				return calculate(left[1]) - calculate(right[1]);
			}
			else {
				return left[0].compareTo(right[0]);
			}
		}
		
		private int calculate(String s) {
			int max = 1;
			for (int i = 0; i < s.length(); ++i) {
				if (max < numeral.get(s.charAt(i))) {
					max = numeral.get(s.charAt(i));
				}
			}
			
			int result = 0;
			int index = 0;
			for (; index < s.length(); ++index) {
				if (numeral.get(s.charAt(index)) == max) {
					result = numeral.get(s.charAt(index)) - result;
					break;
				}
				result += numeral.get(s.charAt(index));
			}
			for (; index < s.length(); ++index) {
				result += numeral.get(s.charAt(index));
			}			
			return result;
		}
	}
}
