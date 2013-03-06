package srm549;

import java.util.ArrayList;
import java.util.Collections;

public class PointyWizardHats {
	public int getNumHats(int[] topHeight, int[] topRadius, int[] bottomHeight, int[] bottomRadius) {
		ArrayList<Cone> top = new ArrayList<Cone>();
		for (int i = 0; i < topHeight.length; ++i) {
			top.add(new Cone(topHeight[i], topRadius[i]));
		}
		Collections.sort(top);
		
		ArrayList<Cone> bottom = new ArrayList<Cone>();
		for (int i = 0; i < bottomHeight.length; ++i) {
			bottom.add(new Cone(bottomHeight[i], bottomRadius[i]));
		}
		Collections.sort(bottom);
		
		int result = 0;
		for (Cone topCone: top) {
			for (Cone bottomCone: bottom) {
				if (topCone.angle < bottomCone.angle && topCone.radius < bottomCone.radius) {
					++result;
					bottom.remove(bottomCone);
					break;
				}
			}
		}
		return result;
	}
	
	class Cone implements Comparable<Cone> {
		public Cone(int height, int radius) {
			this.height = height;
			this.radius = radius;
			this.angle = (double)radius / height;
		}
		int height;
		int radius;
		double angle;
		
		//@Override
		public int compareTo(Cone arg0) {
			// TODO Auto-generated method stub
			if (angle < arg0.angle) {
				return 1;
			}
			else if (angle > arg0.angle) {
				return -1;
			}
			else {
				if (radius < arg0.radius) {
					return 1;
				}
				else if (radius > arg0.radius) {
					return -1;
				}
				else {
					return 0;
				}
			}
		}
	}
}
