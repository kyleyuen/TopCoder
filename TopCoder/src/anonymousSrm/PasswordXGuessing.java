package anonymousSrm;

public class PasswordXGuessing {
	public long howMany(String[] guesses) {
		long result = 0;
		StringBuilder password = new StringBuilder(guesses[0]);
		for (int i = 0; i < password.length(); ++i) {
			for (char a = '0'; a <= '9'; ++a) {
				if (a == guesses[0].charAt(i)) {
					continue;
				}
				else {
					password.setCharAt(i, a);
				}
				
				boolean judge = true;
				for (int j = 1; j < guesses.length; ++j) {
					int differ = 0;
					for (int k = 0; k < guesses[j].length(); ++k) {
						if (password.charAt(k) != guesses[j].charAt(k)) {
							++differ;
						}
					}
					if (differ != 1) {
						judge = false;
						break;
					}
				}
				if (judge) {
					++result;
				}
			}
			password.setCharAt(i, guesses[0].charAt(i));
		}
				
		return result;
	}
}
