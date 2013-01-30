package anonymousSrm;

import java.util.ArrayList;

public class KingXNewBaby {
	public String isValid(String name) {
		if (name.length() != 8) {
			return "NO";
		}
		
		ArrayList<Character> vowels = new ArrayList<Character>();
		for (int i = 0; i < name.length(); ++i) {
			if (name.charAt(i) == 'a' || name.charAt(i) == 'e' || name.charAt(i) == 'i' || name.charAt(i) == 'o' || name.charAt(i) == 'u') {
				vowels.add(name.charAt(i));
			}
		}
		
		if (vowels.size() == 2 && vowels.get(0).compareTo(vowels.get(1)) == 0) {
			return "YES";
		}
		else {
			return "NO";
		}
	}
}
