package anonymousSrm;

public class WorkingRabbits {
	public double getEfficiency(String[] profit) {
		int n = profit.length;
		double profits = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				profits += profit[i].charAt(j) - '0';
			}
		}
		double pairs = n * (n - 1) / 2;
		return profits / pairs;
	}
}
