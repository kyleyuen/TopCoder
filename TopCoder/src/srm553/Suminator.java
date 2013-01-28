package srm553;

import java.util.Stack;

public class Suminator {
	public int findMissing(int[] program, int wantedResult) {
		Stack<Long> stack = new Stack<Long>();
		
		int position = -1;
		for (int i = 0; i < program.length; ++i) {
			if (program[i] == -1) {
				position = 1;
				stack.push((long) 0);
				continue;
			}
			
			if (program[i] == 0) {
				if (stack.size() >= 2) {
					Long a = stack.pop();
					Long b = stack.pop();
					stack.push(a + b);	
					
					if (position != -1 && position != 1) {
						--position;
					}
				}
			}
			else {
				stack.push((long) program[i]);
				if (position != -1) {
					++position;
				}
			}
		}
		
		if (position == 1) {
			if (stack.size() >= 3) {
				stack.pop();
				Long b = stack.pop();
				Long c = stack.pop();
				
				if (b + c == wantedResult) {
					return 0;
				}
			}
			else {
				if (wantedResult - stack.peek() > 0) {
					return (int) (wantedResult - stack.peek());
				}
				else {
					return -1;
				}
			}
		}
		if (stack.peek() == wantedResult) {
			return 0;
		}
		return -1;
	}
}
