package srm567;

public class TheSquareRootDilemma {
	public int countPairs(int N, int M)
	{
	    int res = 0;
	    for (int a = 1; a <= N; a++) {
	        int s = 1;
	        // Find the maximum s such that a is a multiple of s*s:
	        // O(sqrt(N))
	        for (int x = 2; x <= a / x; x++) {
	            if (a % (x*x) == 0) {
	                s = x*x;
	            }
	        }
	        int r = a / s;
	        // a * r is guaranteed to be a perfect square.
	        // If b = r * c, then for a*b to be a perfect square, we
	        // need c to be a perfect square too.
	        // O(sqrt(M))
	        for (int y = 1; y*y*r <= M; y++) {
	            // The pair (a, r*y*y) is a valid pair:
	            res++;
	            // (The loop will stop before y*y*r can overflow 32 bits.)
	        }
	    }
	    return res;
	}
}
