package srm567;

public class NinjaTurtles {
	public int countOpponents(int P, int K) {
        int N = 1;
        // Increase N until the value of the formula is >= P.
        while (3*(N/K) + N/3 < P) {
            N++;
        }
        // If it is equal to P, then N is the result.
        if (3*(N/K) + N/3 == P) {
            return N;
        } else {
            // Else there is no result
            return -1;
        }
	}
}
