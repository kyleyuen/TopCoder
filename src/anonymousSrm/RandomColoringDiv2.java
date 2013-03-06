package anonymousSrm;

public class RandomColoringDiv2 {
	public int getCount(int maxR, int maxG, int maxB, int startR, int startG, int startB, int d1, int d2) {
		int result = 0;
		for (int r = 0; r < maxR; ++r) {
			if (Math.abs(r - startR) > d2) {
				continue;
			}
			
			for (int g = 0; g < maxG; ++g) {
				if (Math.abs(g - startG) > d2) {
					continue;
				}
				
				for (int b = 0; b < maxB; ++b) {
					if (Math.abs(b - startB) > d2) {
						continue;
					}
					
					if ((Math.abs(r - startR) >= d1) || (Math.abs(g - startG) >= d1) || (Math.abs(b - startB) >= d1)) {
						++result;
					}
				}
			}
		}
		return result;
	}

}
