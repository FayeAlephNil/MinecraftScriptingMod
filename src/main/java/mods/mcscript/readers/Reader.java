package mods.mcscript.readers;

import mods.mcscript.utility.Filter;
import mods.mcscript.utility.LogHelper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Reader {
	/**
	 * Reads the files needed and executes them
	 */
	public abstract void readFiles();

	/**
	 * Returns the extension needed for readFiles
	 * @return the extension of the files to be read (e.g. ".clj")
	 */
	protected abstract String getExtension();

	/**
	 * Makes a list of strings representing all the files with the extension from getExtension in path
	 * @param path the path that needs to be scanned for files
	 * @return List of files converted to strings
	 */
	protected ArrayList<String> filesToStrings(String path) {
		//Get the files within path and with the extension
		ArrayList<File> files = Filter.finder(path, getExtension());
		ArrayList<String> strings = new ArrayList<String>();

		//Loop through files unless files is null
		if (files != null) {
			for (File file : files) {
				LogHelper.info("Reading file " + file.toString());

				//Convert the file to a String and add it to the list
				try {
					strings.add(FileUtils.readFileToString(file));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return strings;
	}
}
