package anonymousSrm;

public class MagicNaming {
	public int maxReindeers(String magicName) {
		// the answer is at least 1, since the whole string can be a name.
		int ans = 1 , n = magicName.length(); 
		
        int dp[][] = new int[n][n];
        for (int i = 0 ; i < n ; i++) {
            for (int j = i ; j < n ; j++) {
                if (i == 0) {
                	// The border case.
                    dp[i][j] = 1; 
                }
                else {
                	// If this state is not reachable, then we shouldn't get an answer based on this value, so we set it to -INF.
                    dp[i][j] = -100000000; 
                    
                    for (int k = 0 ; k < i ; k++) {
                    	// x = magicName[k...(i-1)]
                        String A = magicName.substring(k , i); 
                        // y = magicName[i...j]
                        String B = magicName.substring(i , j+1); 
                        // Check the order condition: x (<=c) y.
                        if ((A+B).compareTo(B+A) <= 0) {             	
                            if (dp[i][j] < dp[k][i-1] + 1) { 
                            	// update the DP table.
                                dp[i][j] = dp[k][i-1] + 1;
                            }
                        }
                    }
                }
                
                if (j == n - 1) {
                    if (dp[i][j] > ans) {
                        ans = dp[i][j];
                    }
                }
            }
        }
        return ans;
	}
}
