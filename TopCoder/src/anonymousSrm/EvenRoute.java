package anonymousSrm;

public class EvenRoute {
	public String isItPossible(int[] x, int[] y, int wantedParity) {
		int oddPoint = 0;
		int evenPoint = 0;
		
		int n = x.length;
		for (int i = 0; i < n; ++i) {
			if ((x[i] + y[i]) % 2 == 0) {
				++evenPoint;
			}
			else {
				++oddPoint;
			}
		}
		
		if ((oddPoint == 0 && wantedParity == 1) || (evenPoint == 0 && wantedParity == 0)) {
			return "CANNOT";
		}
		else {
			return "CAN";
		}
	}
}
