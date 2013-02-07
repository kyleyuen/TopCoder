package srm569;

public class TheDeviceDiv2 {
	public String identify(String[] plates) {
		int n = plates[0].length();
		for (int i = 0; i < n; ++i) {
			int ones = 0;
			int zeros = 0;
			for (int j = 0; j < plates.length; ++j) {
				if (plates[j].charAt(i) == '0') {
					++zeros;
				}
				else {
					++ones;
				}
			}
			if (ones < 2 || zeros < 1) {
				return "NO";
			}
		}
		return "YES";
	}
}
