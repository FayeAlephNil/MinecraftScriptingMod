package mods.mcscript.handler;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;

/**
 * @author Strikingwolf
 */
public class LangEvent {
	private HashMap<String, LangHandler> langHandlers = new HashMap<String, LangHandler>();

	public void addHandler(String language, LangHandler langHandler) {langHandlers.put(language, langHandler);}

	@SubscribeEvent
	public void onEvent(Event e) {
		for (LangHandler langHandler : langHandlers.values()) {

			langHandler.callEvent(e);
		}
	}
}
