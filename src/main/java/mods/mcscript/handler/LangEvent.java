package mods.mcscript.handler;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;

/**
 * @author Strikingwolf
 */
public class LangEvent {
	//Map of Strings -> LangHandlers. Map so that outside sources (e.g. JRuby) can access specific LangHandlers
	private HashMap<String, LangHandler> langHandlers = new HashMap<String, LangHandler>();

	/**
	 * Adds a langHandler to langHandlers
	 * @param language the language to add the handler under
	 * @param langHandler handler to add
	 */
	public void addHandler(String language, LangHandler langHandler) {langHandlers.put(language, langHandler);}

	/**
	 * Gets a handler given the language the handler is for
	 * @param language programming language
	 */
	public void getHandler(String language) {langHandlers.get(language);}

	/**
	 * Dispatches the calling of the event to all the langHandlers
	 * @param e event to be passed
	 */
	@SubscribeEvent
	public void onEvent(Event e) {
		for (LangHandler langHandler : langHandlers.values()) {
			langHandler.callEvent(e);
		}
	}
}
