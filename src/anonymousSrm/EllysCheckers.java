package anonymousSrm;

public class EllysCheckers {
	public String getWinner(String board) {
		int steps = 0;
		for (int i = 0; i < board.length() - 1; ++i) {
			if (board.charAt(i) == 'o') {
				steps += board.length() - i - 1;
			}
		}
		if (steps % 2 == 1) {
			return "YES";
		}
		else {
			return "NO";
		}
	}
}
