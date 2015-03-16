package mods.mcscript.readers;

import mods.mcscript.reference.Reference;

/**
 * @author Strikingwolf
 */
public class RubyReader extends Reader {
	/**
	 * Executes ruby files in scripts
	 */
	@Override
	public void readFiles() {
		//Loop through files and eval them
		for (String toEval : filesToStrings("./scripts")) {
			Reference.ruby.evalScriptlet(toEval);
		}
	}

	/**
	 * returns ".rb"
	 * @return extension
	 */
	@Override
	protected String getExtension() {
		return ".rb";
	}
}
