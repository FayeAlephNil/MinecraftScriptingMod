package mods.mcscript.handler;

import cpw.mods.fml.common.eventhandler.Event;
import mods.mcscript.utility.LogHelper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Strikingwolf
 */
public abstract class LangHandler {
	protected static HashMap<String, ArrayList<Object>> toCall = new HashMap<String, ArrayList<Object>>();

	protected abstract void onEvent(Event e, Object block);

	public void addHandler(String eName, Object block) {
		if (toCall.get(eName) == null) {
			toCall.put(eName, new ArrayList<Object>());
		}
		toCall.get(eName).add(block);
	}

	public void callEvent(Event e) {
		for (String key : toCall.keySet()) {
			LogHelper.info("Handling " + e.toString() + "with key " + key);
			if (e.toString().contains(key)) {
				LogHelper.info("Running " + key	+ " event");
				for (Object o : toCall.get(key)) {
					onEvent(e, o);
				}
				LogHelper.info(key + "isCanceled = " + e.isCanceled());
			}
		}
	}
}
