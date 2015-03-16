package mods.mcscript.readers;

import mods.mcscript.reference.Reference;
import mods.mcscript.utility.Clojure;

/**
 * @author Strikingwolf
 */
public class ClojureReader extends Reader {
	/**
	 * executes clojure files in scripts
	 */
	@Override
	public void readFiles() {
		filesToStrings(Reference.SCRIPT_DIR).forEach(Clojure::eval);
	}

	/**
	 * Returns ".clj"
	 * @return extension
	 */
	@Override
	protected String getExtension() {
		return ".clj";
	}
}
