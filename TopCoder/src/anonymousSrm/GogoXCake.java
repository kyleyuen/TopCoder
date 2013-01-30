package anonymousSrm;

public class GogoXCake {
	int cakeRow, cakeColumn;
	int cutterRow, cutterColumn;
	
	public String solve(String[] cake, String[] cutter) {
		cakeRow = cake.length;
		cakeColumn = cake[0].length();
		cutterRow = cutter.length;
		cutterColumn = cutter[0].length();
		
		useCutterFillDish(cake, cutter);
		if (isBakerFull(cake)) {
			return "YES";
		}
		return "NO";
	}

	private void useCutterFillDish(String[] cake, String[] cutter) {
		for (int i = 0; i + cutterRow <= cakeRow; ++i) {
			for (int j = 0; j + cutterColumn <= cakeColumn; ++j) {
				if (isMatch(cake, i, j, cutter)) {
					fillDish(cake, i, j, cutter);
				}
			}
		}
	}

	private boolean isMatch(String[] cake, int currentRow, int currentColumn, String[] cutter) {
		for (int i = 0; i < cutterRow; ++i) {
			for (int j = 0; j < cutterColumn; ++j) {
				if (cutter[i].charAt(j) == '.' && cake[currentRow + i].charAt(currentColumn + j) == 'X') {
					System.out.println(currentRow + " " + currentColumn + "failed");
					return false;
				}
			}
		}
		System.out.println(currentRow + " " + currentColumn + "passed");
		return true;
	}
	
	private void fillDish(String[] cake, int currentRow, int currentColumn, String[] cutter) {
		for (int i = 0; i < cutterRow; ++i) {
			StringBuilder str = new StringBuilder(cake[currentRow + i]);
			for (int j = 0; j < cutterColumn; ++j) {
				if (cutter[i].charAt(j) == '.') {
					str.setCharAt(currentColumn + j, 'X');
				}
			}
			cake[currentRow + i] = str.toString();
		}
	}
	
	private boolean isBakerFull(String[] cake) {
		for (int i = 0; i < cakeRow; ++i) {
			for (int j = 0; j < cakeColumn; ++j) {
				if (cake[i].charAt(j) != 'X') {
					return false;
				}
			}
		}
		return true;
	}

}
