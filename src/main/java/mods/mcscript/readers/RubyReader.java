package mods.mcscript.readers;

import mods.mcscript.reference.Reference;

/**
 * @author Strikingwolf
 */
public class RubyReader extends Reader {
    @Override
    public void readFiles() {
        for (String toEval : filesToStrings(Reference.SCRIPT_DIR)) {
            Reference.ruby.evalScriptlet(toEval);
        }
    }

    @Override
    protected String getExtension() { return ".rb"; }
}