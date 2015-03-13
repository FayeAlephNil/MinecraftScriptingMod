package mods.mcscript.handler;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;

/**
 * @author Strikingwolf
 */
public class LangEvent {
	private ArrayList<LangHandler> langHandlers = new ArrayList<LangHandler>();

	public void addHandler(LangHandler langHandler) {
		langHandlers.add(langHandler);
	}

	@SubscribeEvent
	public void onEvent(Event e) {
		for (LangHandler langHandler : langHandlers) {
			langHandler.callEvent(e);
		}
	}
}
