package srm550;

public class RotatingBot {
	public int minArea(int[] moves) {	
		if (moves.length == 1) {
			return moves[0] + 1;
		}
		else if (moves.length == 2) {
			return (moves[0] + 1) * (moves[1] + 1);
		}
		else if (moves.length == 3) {
			return (Math.max(moves[0], moves[2]) + 1) * (moves[1] + 1);
		}
		else {
			int row;
			int column;
			if (moves[0] < moves[2]) {
				row = moves[2];
				column = moves[3];
				if (moves.length > 5 && moves[4] != moves[2]) {
					return -1;
				}
				if (moves.length > 6 && moves[1] + moves[5] + 1 != moves[3]) {
					return -1;
				}
				for (int i = 6; i < moves.length - 1; ++i) {
					if (moves[i] != moves[i - 2] - 1) {
						return -1;
					}
				}
				if (moves.length > 6 && moves[moves.length - 1] >= moves[moves.length - 3]) {
					return -1;
				}
			}
			else {
				row = moves[0];
				column = moves[1];
				if (moves[0] != moves[2]) {
					return -1;
				}
				for (int i = 3; i < moves.length - 1; ++i) {
					if (moves[i] != moves[i - 2] - 1) {
						return -1;
					}
				}
				if (moves[moves.length - 1] >= moves[moves.length - 3]) {
					return -1;
				}
			}
			return (row + 1) * (column + 1);
		}
	}
}
