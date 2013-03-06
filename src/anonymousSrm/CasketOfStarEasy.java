package anonymousSrm;

public class CasketOfStarEasy {
	public int maxEnergy(int[] weight) {
		int n = weight.length;
		int[][] dp = new int[n][n];
		
		for (int length = 3; length <= n; ++length) {
			for (int i = 0; i + length <= n; ++i) {
				int j = i + length - 1;
				for (int k = i + 1; k <= j - 1; ++k) {
					int value = dp[i][k] + dp[k][j] + weight[i] * weight[j];
					if (dp[i][j] < value) {
						dp[i][j] = value;
					}
				}
			}
		}
		return dp[0][n - 1];
	}
}
