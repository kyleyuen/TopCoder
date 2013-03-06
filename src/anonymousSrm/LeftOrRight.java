package anonymousSrm;

public class LeftOrRight {
	public int maxDistance(String program) {
		int distance = 0;
		StringBuilder sb = new StringBuilder(program);
		for (int i = 0; i < sb.length(); ++i) {
			if (sb.charAt(i) == '?') {
				sb.setCharAt(i, 'L');
			}
		}
		distance = Math.max(distance, evaluate(sb.toString()));
		
		sb = new StringBuilder(program);
		for (int i = 0; i < sb.length(); ++i) {
			if (sb.charAt(i) == '?') {
				sb.setCharAt(i, 'R');
			}
		}
		distance = Math.max(distance, evaluate(sb.toString()));
		
		return distance;
	}

	private int evaluate(String commands) {
		// TODO Auto-generated method stub
		int distance = 0;
		int position = 0;
		for (int i = 0; i < commands.length(); ++i) {
			if (commands.charAt(i) == 'L') {
				--position;
			}
			if (commands.charAt(i) == 'R') {
				++position;
			}
			distance = Math.max(distance, Math.abs(position));
		}
		return distance;
	}
}
