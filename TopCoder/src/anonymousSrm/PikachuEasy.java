package anonymousSrm;

public class PikachuEasy {
	public String check(String word) {
		return word.matches("((pi)|(ka)|(chu))*") ? "YES" : "NO";
	}
}
