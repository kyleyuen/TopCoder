package anonymousSrm;

public class NoRepeatPlaylist {
	public int numPlaylists(int N, int M, int P) {
		long[][] dp = new long[P + 1][N + 1];
		dp[0][0] = 1;
		for (int i = 1; i <= P; ++i) {
			for (int j = 1; j <= N; ++j) {
				dp[i][j] = dp[i - 1][j - 1] * (N - j + 1);
				if (j > M) {
					dp[i][j] += (dp[i - 1][j] * (j - M));
				}
				dp[i][j] %= 1000000007;
			}
		}
		return (int)dp[P][N];
	}
}