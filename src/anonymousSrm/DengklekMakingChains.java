package anonymousSrm;

import java.util.ArrayList;

public class DengklekMakingChains {
	public int maxBeauty(String[] chains) {
		int result = 0;
		int backUp = 0;
		ArrayList<String> prefix = new ArrayList<String>();
		ArrayList<String> suffix = new ArrayList<String>();
		
		for (String str : chains) {
			if (isClean(str)) {
				result += getCleanValue(str);
				continue;
			}			
			if (isIsolate(str)) {
				if (backUp < str.charAt(1) - '0') {
					backUp = str.charAt(1) - '0';
				}
				continue;
			}
			
			if (str.charAt(2) != '.') {
				prefix.add(str);
			}
			if (str.charAt(0) != '.') {
				suffix.add(str);
			}
		}
				
		int prefixAndSuffixValue = 0;
		prefix.add("..0");
		suffix.add("0..");
		for (String p : prefix) {
			for (String s : suffix) {
				if (p != s) {
					int prefixValue = getPrefixValue(p);
					int suffixValue = getSuffixValue(s);
					if (prefixAndSuffixValue < prefixValue + suffixValue) {
						prefixAndSuffixValue = prefixValue + suffixValue;
					}
				}
			}
		}
		
		result += prefixAndSuffixValue;
		if (result < backUp) {
			result = backUp;
		}
		return result;
	}

	private int getPrefixValue(String p) {
		// TODO Auto-generated method stub
		int value = 0;
		for (int i = p.length() - 1; i >= 0; --i) {
			if (p.charAt(i) == '.') {
				break;
			}
			value += p.charAt(i) - '0';
		}
		return value;
	}

	private int getSuffixValue(String s) {
		// TODO Auto-generated method stub
		int value = 0;
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) == '.') {
				break;
			}
			value += s.charAt(i) - '0';
		}
		return value;
	}

	private int getCleanValue(String str) {
		// TODO Auto-generated method stub
		int value = 0;
		for (int i = 0; i < str.length(); ++i) {
			value += str.charAt(i) - '0';
		}
		return value;
	}

	private boolean isIsolate(String str) {
		// TODO Auto-generated method stub
		return (str.charAt(0) == '.' && str.charAt(1) != '.' && str.charAt(2) == '.');
	}

	private boolean isClean(String str) {
		// TODO Auto-generated method stub
		for (int i = 0; i < str.length(); ++i) {
			if (str.charAt(i) == '.') {
				return false;
			}
		}
		return true;
	}
}