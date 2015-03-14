package mods.mcscript.readers;

import mods.mcscript.utility.Filter;
import mods.mcscript.utility.LogHelper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Reader {
	public abstract void readFiles();

	protected abstract String getExtension();

	protected ArrayList<String> filesToStrings(String path) {
		File[] files = Filter.finder(path, getExtension());
		ArrayList<String> strings = new ArrayList<String>();
		if (files != null) {
			for (File file : files) {
				LogHelper.info("Reading file " + file.toString());
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
