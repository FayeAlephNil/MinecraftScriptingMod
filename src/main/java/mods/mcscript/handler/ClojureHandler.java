package mods.mcscript.handler;

import clojure.lang.IFn;
import cpw.mods.fml.common.eventhandler.Event;

/**
 * @author Strikingwolf
 */
public class ClojureHandler extends LangHandler {
	@Override
	protected void onEvent(Event e, Object block) {
		if (block instanceof IFn) {
			IFn fn = (IFn) block;
			fn.invoke(e);
		}
	}
}
