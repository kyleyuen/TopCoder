package srm550;

public class EasyConversionMachine {
	public String isItPossible(String originalWord, String finalWord, int k) {
		int differ = 0;
		for (int i = 0; i < originalWord.length(); ++i) {
			if (originalWord.charAt(i) != finalWord.charAt(i)) {
				++differ;
			}
		}
		
		if ((differ > k) || (Math.abs(differ - k) % 2 == 1)) {
			return "IMPOSSIBLE";
		}
		else {
			return "POSSIBLE";
		}
	}
}
