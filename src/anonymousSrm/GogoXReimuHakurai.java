package anonymousSrm;

public class GogoXReimuHakurai {	
	public int solve(String[] choices) {		
		int m = 0;
		for (int i = 0; i < choices.length; ++i) {
			for (int j = 0; j < choices[i].length(); ++j) {
				if (choices[i].charAt(j) == 'Y') {
					++m;
				}
			}
		}
		return m - choices.length + 2;
	}
}
