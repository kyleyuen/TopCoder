package anonymousSrm;

public class PatrolRoute {
	public int countRoutes(int X, int Y, int minT, int maxT) {
		int upper = maxT / 2;
		int lower = minT / 2;
		
		return calculate(X, Y, upper) - calculate(X, Y, lower);
	}

	private int calculate(int X, int Y, int bound) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
