package mods.mcscript.handler;

import cpw.mods.fml.common.eventhandler.Event;
import mods.mcscript.utility.LogHelper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Strikingwolf
 */
public abstract class LangHandler {
	//Map of EventStrings -> Object lists that will be called when the event happens
	protected static HashMap<String, ArrayList<Object>> toCall = new HashMap<String, ArrayList<Object>>();

	/**
	 * Executes block with parameter e
	 * @param e event to be passed
	 * @param block block to be executed
	 */
	protected abstract void onEvent(Event e, Object block);

	/**
	 * Adds a handler (block) that will be executed when the event under eName happens
	 * @param eName name of an event
	 * @param block block to be executed
	 */
	public void addHandler(String eName, Object block) {
		if (toCall.get(eName) == null) {
			toCall.put(eName, new ArrayList<Object>());
		}
		toCall.get(eName).add(block);
	}

	/**
	 * to be executed when an event happens
	 * @param e event
	 */
	public void callEvent(Event e) {
		//Loop through all keys
		for (String key : toCall.keySet()) {
			LogHelper.info("Handling " + e.toString() + "with key " + key);
			//If the key is contained in the event name then
			if (e.toString().contains(key)) {
				//Call onEvent with the event name and using all the blocks
				LogHelper.info("Running " + key	+ " event");
				for (Object o : toCall.get(key)) {
					onEvent(e, o);
				}
				LogHelper.info(key + "isCanceled = " + e.isCanceled());
			}
		}
	}
}
