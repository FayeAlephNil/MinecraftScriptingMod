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
		filesToStrings(Reference.SCRIPT_DIR).forEach(Reference.ruby::evalScriptlet);
    }

	/**
	 * returns ".rb"
	 * @return extension
	 */
    @Override
    protected String getExtension() { return ".rb"; }
}
