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
		for (String toEval : filesToStrings(Reference.SCRIPT_DIR)) {
			Clojure.eval(toEval);
		}
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
