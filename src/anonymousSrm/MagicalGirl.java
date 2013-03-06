package anonymousSrm;

public class MagicalGirl {
    public double maxExpectation(int M, int[] d, int[] w, int[] g)
    {
        int N = d.length;
        double dp[][] = new double[N+1][M+1];
        int day[] = new int[N+1];
        double win[] = new double[N+1];
        int gain[] = new int[N+1];
        boolean alreadyAdd[] = new boolean[N];
        day[0] = 0;
		// The following code is for sort. It's a Selecting Sorting, which runs in O(N^2).
        for(int i = 1 ; i <= N ; i++)
        {
            int earliest = 100000000 , which = 0;
            for(int j = 0 ; j < N ; j++)
                if(!alreadyAdd[j])
                    if(d[j] < earliest)
                    {
                        earliest = d[j];
                        which = j;
                    }
            alreadyAdd[which] = true;
            day[i] = d[which];
            win[i] = w[which] / 100.0;
            gain[i] = g[which];
        }
		// The DP part starts.
        for(int i = N ; i >= 0 ; i--) // We must do DP in decreasing order of i, since DP[i][x] depends on DP[i+1][y].
            for(int j = 1 ; j <= M ; j++) // for j, you can do it for any order.
            {
                if(i == N || (j - (day[i+1] - day[i]) <= 0)) // In case of: you only have the choice to waiting the death.
                    dp[i][j] = (day[i] + j) * 1.00;
                else
                {
                    int LifePointAfterBattle = Math.min(M , j - (day[i+1] - day[i]) + gain[i+1]);
                    dp[i][j] = Math.max(dp[i+1][j-(day[i+1]-day[i])] , // Case: Don't Battle.
                               (1.0-win[i+1]) * day[i+1] + // Case: Battle but loss.
                               win[i+1] * dp[i+1][LifePointAfterBattle]); // Case: Battle and win.
                }
            }
        return dp[0][M];
    }
}
