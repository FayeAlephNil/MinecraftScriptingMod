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
        for (String toEval : filesToStrings(Reference.SCRIPT_DIR)) {
            Reference.ruby.evalScriptlet(toEval);
        }
    }

	/**
	 * returns ".rb"
	 * @return extension
	 */
    @Override
    protected String getExtension() { return ".rb"; }
}
