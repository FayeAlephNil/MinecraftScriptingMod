package mods.mcscript;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import mods.mcscript.proxy.CommonProxy;
import mods.mcscript.readers.Reader;
import mods.mcscript.reference.Reference;
import mods.mcscript.utility.LogHelper;
import net.minecraftforge.common.MinecraftForge;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Files;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class MCScript
{


    @Mod.Instance(Reference.MOD_ID)
    public static MCScript instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        if (Files.notExists(FileSystems.getDefault().getPath(Reference.SCRIPT_DIR)))
        {
            File dir = new File(Reference.SCRIPT_DIR);
            dir.mkdir();
            System.out.println("Script Directory Made");
        }
		Reference.readers.forEach(mods.mcscript.readers.Reader::readFiles);

        proxy.registerKeyBindings();
        proxy.initRenderers();
        proxy.initSounds();
        LogHelper.info("Pre Initialization Complete");
    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event)
    {
		//Registers langEvent
		MinecraftForge.EVENT_BUS.register(Reference.langEvent);
		LogHelper.info("Initialization Complete");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.info("Post Initialization Complete");
    }
}
