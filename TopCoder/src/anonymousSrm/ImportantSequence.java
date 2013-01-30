package anonymousSrm;

public class ImportantSequence {
	public int getCount(int[] B, String operators)
	{
	    int n = B.length;
	    int s = 1;
	    long t = 0;
	    final long INF = Long.MAX_VALUE;
	    long lowBound = 0;
	    long upperBound = INF;
	    for (int i=0; i<=n; i++) {
	        // value of the last number is
	        // a0*s + t  > 0
	        // a0*s > -t
	        if (s == -1) {
	            // -a0 > -t
	            // a0 < t
	            upperBound = Math.min(upperBound, t);
	        } else {
	            // a0 > -t
	            lowBound = Math.max(lowBound, -t);
	        }
	        
	        if (i==n) {
	            break;
	        }
	        if ( operators.charAt(i) == '-') {
	            //new number is:
	            //  B[i]   = (a0*s + t) - A[i+1]
	            //  A[i+1] = (a0*s + t - B[i])
	            t -= B[i];
	        } else {
	            //new number is:
	            //  B[i]   = (a0*s + t) + A[i+1]
	            //  A[i+1] = B[i] - (a0*s + t)
	            //  A[i+1] = B[i] - a0*s - t
	            s *= -1;
	            t = -t + B[i];
	        }
	        
	                    
	    }
	    if (upperBound == INF) {
	        return -1;
	    }
	    if (upperBound <= lowBound) {
	        return 0;
	    }
	    return (int)( upperBound - lowBound - 1);
	}
	
}
