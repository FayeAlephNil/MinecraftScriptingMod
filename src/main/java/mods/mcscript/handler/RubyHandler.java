package mods.mcscript.handler;

import cpw.mods.fml.common.eventhandler.Event;
import mods.mcscript.reference.Reference;
import org.jruby.javasupport.JavaUtil;
import org.jruby.runtime.Block;
import org.jruby.runtime.ThreadContext;

public class RubyHandler extends LangHandler {
	@Override
    protected void onEvent(Event event, Object code) {
		if (code instanceof Block) {
			Block block = (Block) code;
			block.call(ThreadContext.newContext(Reference.ruby), JavaUtil.convertJavaToUsableRubyObject(Reference.ruby, event));
		}
    }
}