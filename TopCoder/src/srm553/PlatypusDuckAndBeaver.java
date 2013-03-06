package srm553;

public class PlatypusDuckAndBeaver {
	public int minimumAnimals(int webbedFeet, int duckBills, int beaverTails) {
		for (int duck = 0; duck <= webbedFeet / 2; ++duck) {
			for (int beaver = 0; beaver <= beaverTails; ++beaver) {
				for (int platypus = 0; platypus <= duckBills; ++platypus) {
					if (duck * 2 + beaver * 4 + platypus * 4 == webbedFeet) {
						if (duck + platypus == duckBills) {
							if (beaver + platypus == beaverTails) {
								return duck + beaver + platypus;
							}
						}
					}
				}
			}
		}
		return 0;
	}
}
