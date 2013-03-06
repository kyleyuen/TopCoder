package anonymousSrm;

public class SkewedPerspectives {
	public String[] areTheyPossible(int[] cubes, int B, int w, String[] views) {		
		int n = views.length;
        String[] res = new String[n];
        int[] copyCubes = new int[3]; 
        for (int i=0; i<n; i++) {
            for (int j=0; j<3; j++) {
                copyCubes[j] = cubes[j];
            }
            res[i] = (isItPossible(copyCubes, B, w, views[i]) ? "valid" : "invalid" );
        }
        return res;
	}

	boolean isItPossible(int[] cubes, int B, int w, String view)
    {
        int t = 0; //overall number of cubes.
        for (int i=0; i<cubes.length; i++) {
            t += cubes[i];
        }
        int i = 0;
        int usedColumns = 1;
        int mustFill = 0;
        // Visit the view feom bottom to top.
        while (i < view.length()) {
            int j = i;
            // Count the number of black squares starting at i.
            while ( (j < view.length()) && (view.charAt(j)=='b') ) {
                j++;
            }
            if (j != i) {
                int black = j - i;
                if (j == 1) {
                    return false;
                }
              
                B -= black/2;
                if (black % 2 != 0) {
                    // If the group is odd, place the lowest prism of the group
                    // as low as possible in the next row.
                    B--;
                    usedColumns++;
                    // This formula can handle the case in which  a sequence o f!
                    int x = j - 2;
                    mustFill += (i - 1) / 2; //Amount of 2x1 spaces to fill.
                    if (x % 2 == 1) { //If the height of the empty space is odd
                        t--;          //we would need to use a cube to r
                    }
                }
                i = j;

            } else {
                int c = (int)(view.charAt(i) - '0' );
                cubes[c] --;
                t--;
                i++;
            }
        }
        // Verify there were enough prisms:
        if (B < 0) {
            return false;
        }
        //Now verify it is possible to fill the emty spaces.
        int bfill = Math.min(mustFill, B); //how many prisms are we going to use to f
        mustFill -=  bfill;
        B -= bfill;
        t -= 2 * mustFill;
        if ( (t < 0) || (usedColumns > w) ) {
            return false;
        }
        if ( (cubes[0] < 0) || (cubes[1] < 0) || (cubes[2] < 0) ) {
            return false;
        }
        return true;
    }
}
