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

	//References
    public static final String MOD_ID = "MCScript";
    public static final String MOD_NAME = "MCScript";
    public static final String VERSION = "1.7.10-1.0";
    public static final String CLIENT_PROXY_CLASS = "mods.mcscript.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "mods.mcscript.proxy.ServerProxy";


	//Setup the list of readers and a LangEvent instance
	public static ArrayList<Reader> readers = new ArrayList<Reader>();
	public static LangEvent langEvent = new LangEvent();

	//Add to the list of readers and the langEvent instance
	static {
		readers.add(new ClojureReader());
		readers.add(new RubyReader());

		langEvent.addHandler("clojure", new ClojureHandler());
		langEvent.addHandler("jruby", new RubyHandler());
	}

	//Get an instance of Ruby from JRuby
	public static final Ruby ruby = Ruby.newInstance();
    public static final String SCRIPT_DIR = "mcsm-scripts";
}