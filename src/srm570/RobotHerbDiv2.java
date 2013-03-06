package srm570;

public class RobotHerbDiv2 {
	public int getdist(int T, int[] a) {
		int x = 0;
		int y = 0;
		int state = 0;
		for (int i = 0; i < T; ++i) {
			for (int j = 0; j < a.length; ++j) {
				switch (state) {
				case 0:
					y += a[j];
					break;
				case 1:
					x += a[j];
					break;
				case 2:
					y -= a[j];
					break;
				case 3:
					x -= a[j];
					break;
				}
				state = (state + a[j]) % 4;
			}
		}
		
		return Math.abs(x) + Math.abs(y);
	}
}
