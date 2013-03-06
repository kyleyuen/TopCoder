package anonymousSrm;

public class BinaryPolynomialDivTwo {
	public int countRoots(int[] a) {
		int counter = 0;
		for (int i = 1; i < a.length; ++i) {
			if (a[i] == 1) {
				++counter;
			}
		}
		
		int result = 0;
		if (a[0] == 0) {
			++result;
			if (counter % 2 == 0) {
				++result;
			}
		}
		else {
			if (counter % 2 == 1) {
				++result;
			}
		}
		return result;
	}
}
