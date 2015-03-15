package mods.mcscript.readers;

import mods.mcscript.reference.Reference;
import mods.mcscript.utility.Clojure;

/**
 * @author Strikingwolf
 */
public class ClojureReader extends Reader {
	@Override
	public void readFiles() {
		for (String toEval : filesToStrings(Reference.SCRIPT_DIR)) {
			Clojure.eval(toEval);
		}
	}

	@Override
	protected String getExtension() {
		return ".clj";
	}
}
