package anonymousSrm;

public class FoxAndIntegers {
	public int[] get(int AminusB, int BminusC, int AplusB, int BplusC) {
		if (((AminusB + AplusB) % 2 == 1) || ((AminusB - AplusB) % 2 == 1) || ((BminusC + BplusC) % 2 == 1) || ((BminusC - BplusC) % 2 == 1) 
				|| ((BminusC + BplusC) != (AplusB - AminusB))) {
			return new int[0];
		}
		else {
			int[] array = new int[3];
			array[0] = (AminusB + AplusB) / 2;
			array[1] = (AplusB - AminusB) / 2;
			array[2] = (BplusC - BminusC) / 2;
			return array;
		}
	}
	
}
