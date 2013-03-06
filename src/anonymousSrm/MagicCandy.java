package anonymousSrm;

public class MagicCandy {
	public int whichOne(int n) {
		int base = (int)Math.sqrt(n - 1);
		int carry = base;
		base *= base;
		if (n <= base + carry) {
			carry = 0;
		}
		return base + carry + 1;
	}
}
