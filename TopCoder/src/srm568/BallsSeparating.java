package srm568;

public class BallsSeparating {
	public int minOperations(int[] red, int[] green, int[] blue) {
		int INF = 1<<30; // A high value to determine impossible cases.
	    // It is only impossible when there are less than 3 boxes.

	    int res = INF;
	    int n = red.length;
	    for (int r = 0; r < n; r++) {
	        for (int g = 0; g < n; g++) if (r != g) {
	            for (int b = 0; b < n; b++) if (b != g && b != r) {
	                int moves = 0;
	                for (int i=0; i<n; i++) {
	                    int cr = blue[i] + green[i]; //cost to make the box red
	                    int cb = red[i] + green[i]; //cost to make blue
	                    int cg = red[i] + blue[i]; //cost to make green
	                    if (i == r) {
	                        // must pick red:
	                        moves += cr;
	                    } else if (i == g) {
	                        // must pick green:
	                        moves += cg;
	                    } else if (i == b) {
	                        // must pick blue:
	                        moves += cb;
	                    } else {
	                        // Pick the minimum cost:
	                        moves += Math.min(cr, Math.min(cb,cg));
	                    }
	                }
	                res = Math.min(res, moves);
	            }
	        }
	    }

	    return (res < INF) ? res : -1;
	}

}
