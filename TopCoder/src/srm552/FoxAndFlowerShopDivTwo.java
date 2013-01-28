package srm552;

public class FoxAndFlowerShopDivTwo {
	public int theMaxFlowers(String[] flowers, int r, int c) {
		int row = flowers.length;
		int column = flowers[0].length();
		int[][] counter = new int[row + 1][column + 1];
		for (int i = 1; i <= row; ++i) {
			for (int j = 1; j <= column; ++j) {
				counter[i][j] = counter[i - 1][j] + counter[i][j - 1] - counter[i - 1][j - 1];
				if (flowers[i - 1].charAt(j - 1) == 'F') {
					++counter[i][j];
				}
			}
		}
		
		int result = 0;
		for (int x1 = 1; x1 <= row; ++x1) {
			for (int y1 = 1; y1 <= column; ++y1) {
				for (int x2 = x1; x2 <= row; ++x2) {
					for (int y2 = y1; y2 <= column; ++y2) {
						if ((x1 <= r + 1 && r + 1 <= x2) && (y1 <= c + 1 && c + 1 <= y2)) {
							continue;
						}
						int temp = counter[x2][y2] - counter[x2][y1 - 1] - counter[x1 - 1][y2] + counter[x1 - 1][y1 - 1];
						result = Math.max(result, temp);
					}
				}
			}
		}
		return result;
	}
}
