package mods.mcscript.handler;

import clojure.lang.IFn;
import cpw.mods.fml.common.eventhandler.Event;

/**
 * @author Strikingwolf
 */
public class ClojureHandler extends LangHandler {
	/**
	 * Executes the block with the parameter e
	 * @param e event to be passed to block
	 * @param block block to be executed
	 */
	@Override
	protected void onEvent(Event e, Object block) {
		//If block is an IFn then execute it with the parameter e
		if (block instanceof IFn) {
			IFn fn = (IFn) block;
			fn.invoke(e);
		}
	}
}
