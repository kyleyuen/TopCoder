package anonymousSrm;

public class EllysDirectoryListing {
	public String[] getFiles(String[] files) {
		int length = files.length;
		if ((files[length - 1].equals(".") && files[length - 2].equals("..")) || (files[length - 1].equals("..") && files[length - 2].equals("."))) {
			return files;
		}
		
		for (int i = 0; i < length; ++i) {
			if (files[i].equals(".") || files[i].equals("..")) {
				String temp = files[i];
				files[i] = files[length - 1];
				files[length - 1] = temp;
				break;
			}
		}
		
		if ((files[length - 1].equals(".") && files[length - 2].equals("..")) || (files[length - 1].equals("..") && files[length - 2].equals("."))) {
			return files;
		}
		
		for (int i = 0; i < length; ++i) {
			if (files[i].equals(".") || files[i].equals("..")) {
				String temp = files[i];
				files[i] = files[length - 2];
				files[length - 2] = temp;
				break;
			}
		}
		return files;
	}
}
