package mods.mcscript.utility;

import java.io.File;
import java.io.FilenameFilter;

public class Filter {

	/**
	 * Searches the dir for files that end with endsWith
	 * @param dirName directory to search
	 * @param endsWith extension that files will end with
	 * @return files that end with endsWith in dirName
	 */
	public static File[] finder(String dirName, final String endsWith) {
		File dir = new File(dirName);

		return dir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String filename)
			{ return filename.endsWith(endsWith); }
		} );

	}
}