package anonymousSrm;

import java.util.Arrays;

public class PrinceXToastbook {
	public double eat(int[] prerequisite) {
		boolean[] vist = new boolean[54];
		double ret = 0.0;
		
		for(int i = 0; i < prerequisite.length; ++i){
			Arrays.fill(vist, false);
			
			double prob = 1.0;
			int needs = 0;
			for(int j = i; j != -1; j = prerequisite[j]){
				if(vist[j]){
					prob = 0.0; 
					break;
				}
				vist[j] = true;
				++needs;
				prob /= needs;
			}
			ret += prob;
		}
		
		return ret;
	}
}
