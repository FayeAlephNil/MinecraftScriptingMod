package mods.mcscript.readers;

import mods.mcscript.utility.Clojure;
import mods.mcscript.utility.Filter;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Strikingwolf
 */
public class ClojureReader implements IReader {

	@Override
	public void readFiles() {
		File[] files = Filter.finder("./scripts", ".clj");
		ArrayList<String> toExectute = new ArrayList<String>();
		for (File file : files) {
			try {
				toExectute.add(FileUtils.readFileToString(file));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		for (String str : toExectute) {
			Clojure.eval(str);
		}
	}
}
