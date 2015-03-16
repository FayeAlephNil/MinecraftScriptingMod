package mods.mcscript.readers;

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
		//Loop through files and eval them
		for (String toEval : filesToStrings("./scripts")) {
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
