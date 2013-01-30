package anonymousSrm;

public class KingXNewCurrency {
	public int howMany(int A, int B, int X) {
		if(A % X == 0 && B % X == 0) {
			return -1;
		}
		
		int limit = Math.max(A, B);
		int result = 0;
		for(int Y = 1; Y <= limit; ++Y) {
			if(Y != X && isCombination(A, X, Y) && isCombination(B, X, Y)) {
				++result;
			}
		}
		
		return result;
	}

	private boolean isCombination(int num, int X, int Y) {
		// TODO Auto-generated method stub
		for(int n = 0; X*n <= num; ++n) {
			if((num-X*n)%Y == 0) {
				return true;
			}
		}
		return false;
	}
	
}
