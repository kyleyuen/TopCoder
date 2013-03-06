package srm551;

import java.util.HashSet;

public class ColorfulBricks {
	public int countLayouts(String bricks) {
		HashSet<Character> color = new HashSet<Character>();
		for (int i = 0; i < bricks.length(); ++i) {
			color.add(bricks.charAt(i));
		}
		
		if (color.size() == 1) {
			return 1;
		}
		else if (color.size() == 2) {
			return 2;
		}
		else {
			return 0;
		}
	}
}
