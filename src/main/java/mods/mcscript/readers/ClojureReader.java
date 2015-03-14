package mods.mcscript.readers;

import mods.mcscript.utility.Clojure;

/**
 * @author Strikingwolf
 */
public class ClojureReader extends Reader {
	@Override
	public void readFiles() {
		for (String toEval : filesToStrings("./scripts")) {
			Clojure.eval(toEval);
		}
	}

	@Override
	protected String getExtension() {
		return ".clj";
	}
}
