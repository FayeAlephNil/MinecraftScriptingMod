package mods.mcscript.reference;

import mods.mcscript.handler.ClojureHandler;
import mods.mcscript.handler.LangEvent;
import mods.mcscript.handler.RubyHandler;
import mods.mcscript.readers.ClojureReader;
import mods.mcscript.readers.Reader;
import mods.mcscript.readers.RubyReader;
import org.jruby.Ruby;

import java.util.ArrayList;

public class Reference {
    public static final String MOD_ID = "MCScript";
    public static final String MOD_NAME = "MCScript";
    public static final String VERSION = "1.7.10-1.0";
    public static final String CLIENT_PROXY_CLASS = "mods.mcscript.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "mods.mcscript.proxy.ServerProxy";
    public static final String GUI_FACTORY_CLASS = "mods.mcscript.client.gui.GuiFactory";

	public static ArrayList<Reader> readers = new ArrayList<Reader>();
	public static LangEvent langEvent = new LangEvent();

	static {
		readers.add(new ClojureReader());
		readers.add(new RubyReader());

		langEvent.addHandler("clojure", new ClojureHandler());
		langEvent.addHandler("jruby", new RubyHandler());
	}

	public static final Ruby ruby = Ruby.newInstance();
}