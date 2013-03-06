package anonymousSrm;

import java.util.Arrays;

public class MergersDivTwo {
	public double findMaximum(int[] revenues, int k) {
		Arrays.sort(revenues);
        int[] sum = new int[revenues.length + 1];
        sum[0] = 0;
        for (int i = 1; i <= revenues.length; ++i) {
            sum[i] = sum[i - 1] + revenues[revenues.length - i];
        }
        double[] dp = new double[revenues.length - k + 1];
        for (int i = dp.length - 1; i >= 0; --i) {
            dp[i] = (sum[revenues.length] - sum[i]) / (double) (revenues.length - i);
            for (int merged = k; i + merged - 1 < dp.length; ++merged) {
                dp[i] = Math.max(dp[i], (dp[i + merged - 1] + sum[i + merged - 1] - sum[i]) / (double) merged);
            }
        }
        return dp[0];
	}
}
