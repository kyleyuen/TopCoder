package anonymousSrm;

public class PasswordXGrid {
	public int minSum(String[] horizontal, String[] vertical) {
		int row = horizontal.length;
		int column = vertical[0].length();
		int[][] dp = new int[row][column];
		
		dp[0][0] = 0;
		for (int j = 1; j < column; ++j) {
			dp[0][j] = dp[0][j - 1] + horizontal[0].charAt(j - 1) - '0';
		}
		for (int i = 1; i < row; ++i) {
			dp[i][0] = dp[i - 1][0] + vertical[i - 1].charAt(0) - '0';
			for (int j = 1; j < column; ++j) {
				if (dp[i - 1][j] + (vertical[i - 1].charAt(j) - '0') > dp[i][j - 1] + (horizontal[i].charAt(j - 1) - '0')) {
					dp[i][j] = dp[i - 1][j] + (vertical[i - 1].charAt(j) - '0');
				}
				else {
					dp[i][j] = dp[i][j - 1] + (horizontal[i].charAt(j - 1) - '0');
				}
			}
		}
		
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < column; ++j) {
				System.out.print(dp[i][j] + "\t");
			}
			System.out.println();
		}
		
		return dp[row - 1][column - 1];
	}
}
