package anonymousSrm;

public class MinCostPalindrome {
	public int getMinimum(String s, int oCost, int xCost) {
		int cost = 0;
		for (int i = 0; i < s.length() / 2; ++i) {
			if (s.charAt(i) == '?' && s.charAt(s.length() - i - 1) == '?') {
				cost += (oCost < xCost) ? oCost*2: xCost*2; 
			}
			else if (s.charAt(i) == '?' && s.charAt(s.length() - i - 1) != '?') {
				if (s.charAt(s.length() - i - 1) == 'o') {
					cost += oCost;
				}
				else {
					cost += xCost;
				}
			}
			else if (s.charAt(i) != '?' && s.charAt(s.length() - i - 1) == '?') {
				if (s.charAt(i) == 'o') {
					cost += oCost;
				}
				else {
					cost += xCost;
				}
			}
			else if (s.charAt(i) != s.charAt(s.length() - i - 1)){
				return -1;
			}
		}
		return cost;
	}
}
