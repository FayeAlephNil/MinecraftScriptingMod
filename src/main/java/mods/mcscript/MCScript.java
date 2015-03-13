package mods.mcscript;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import mods.mcscript.handler.ClojureHandler;
import mods.mcscript.handler.LangEvent;
import mods.mcscript.proxy.CommonProxy;
import mods.mcscript.readers.ClojureReader;
import mods.mcscript.readers.IReader;
import mods.mcscript.reference.Reference;
import mods.mcscript.utility.LogHelper;
import net.minecraftforge.common.MinecraftForge;

import java.util.ArrayList;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class MCScript
{
	public static ArrayList<IReader> readers = new ArrayList<IReader>();
	public static LangEvent langEvent = new LangEvent();

	static {
		readers.add(new ClojureReader());

		langEvent.addHandler(new ClojureHandler());
	}

    @Mod.Instance(Reference.MOD_ID)
    public static MCScript instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
		for (IReader reader : readers) {reader.readFiles();}

        proxy.registerKeyBindings();
        proxy.initRenderers();
        proxy.initSounds();

        LogHelper.info("Pre Initialization Complete");
    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event)
    {
		MinecraftForge.EVENT_BUS.register(langEvent);
		LogHelper.info("Initialization Complete");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.info("Post Initialization Complete");
    }
}
