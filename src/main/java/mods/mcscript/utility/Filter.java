package mods.mcscript.utility;

import mods.mcscript.reference.Reference;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;

public class Filter {

	/**
	 * Searches the dir for files that end with endsWith
	 * @param dirName directory to search
	 * @param endsWith extension that files will end with
	 * @return files that end with endsWith in dirName
	 */
	public static ArrayList<File> finder(String dirName, final String endsWith) {
		File dir = new File(dirName);
		File[] files = dir.listFiles();
		ArrayList<File> toReturn = finderNonRec(dir, endsWith);

		if (files != null) {
			for (File file : files) {
				if (file.isDirectory() && !file.toString().equals(Reference.LIB_DIR)) {
					toReturn.addAll(finderNonRec(file, endsWith));
				}
			}
		}

		return toReturn;
	}

	public static ArrayList<File> finderNonRec(File dir, final String endsWith) {

		return new ArrayList<File>(Arrays.asList(dir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String filename) {
				return filename.endsWith(endsWith);
			}
		})));
	}
}