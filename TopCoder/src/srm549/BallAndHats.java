package srm549;

public class BallAndHats {
	public int getHat(String hats, int numSwaps) {
		int position = 0;
		if ((hats.charAt(0) == 'o') && (numSwaps % 2 == 1)) {
			position = 1;
		}
		if ((hats.charAt(1) == 'o') && (numSwaps % 2 == 0)) {
			position = 1;
		}
		if (hats.charAt(2) == 'o') {
			if (numSwaps == 0) {
				position = 2;
			}
			if (numSwaps % 2 == 1) {
				position = 1;
			}
		}
		return position;
	}
}
