package mods.mcscript.handler;

import cpw.mods.fml.common.eventhandler.Event;
import mods.mcscript.reference.Reference;
import org.jruby.javasupport.JavaUtil;
import org.jruby.runtime.Block;
import org.jruby.runtime.ThreadContext;

public class RubyHandler extends LangHandler {
	/**
	 * Executes the code object with the event parameter passed to it
	 * @param event event to be passed to block
	 * @param code code to be executed
	 */
	@Override
    protected void onEvent(Event event, Object code) {
		//If the code is a Block from JRuby we execute it in the current runtime passing it the event (converted to JRuby object)
		if (code instanceof Block) {
			Block block = (Block) code;
			block.call(ThreadContext.newContext(Reference.ruby), JavaUtil.convertJavaToUsableRubyObject(Reference.ruby, event));
		}
    }
}