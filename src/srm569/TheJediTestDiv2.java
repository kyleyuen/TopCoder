package srm569;

public class TheJediTestDiv2 {
	public int countSupervisors(int[] students, int Y, int J) {
		int maxDiff = 0;
		
		int result = 0;
		for (int i = 0; i < students.length; ++i) {
			int amount = students[i] / J;
			if (students[i] % J != 0) {
				++amount;
			}
			result += amount;
			
			int replace;
			if (Y > students[i]) {
				replace = 0;
			}
			else {
				replace = (students[i] - Y) / J;
				if ((students[i] - Y) % J != 0) {
					++replace;
				}
			}
			if (maxDiff < amount - replace) {
				maxDiff = amount - replace;
			}
		}
		result -= maxDiff;
		return result;
	}
}
