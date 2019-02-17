package com.kjmaster.endertotem;

import com.kjmaster.endertotem.utils.ConfigHandler;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

import static com.kjmaster.endertotem.proxy.CommonProxy.proxy;

@Mod(modid = EnderTotem.MODID, version = EnderTotem.VERSION, dependencies = EnderTotem.DEPENDENCIES)
public class EnderTotem
{
    public static final String MODID = "endertotem";
    public static final String VERSION = "1.0.6";
    public static final String CLIENT_PROXY = "com.kjmaster.endertotem.proxy.ClientProxy";
    public static final String COMMON_PROXY = "com.kjmaster.endertotem.proxy.CommonProxy";
    public static final String DEPENDENCIES = "required-after:draconicevolution;required-after:codechickenlib;required-after:kjlib";

    private static File configDir;
    public static File getConfigDir() { return configDir; }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        configDir = new File(event.getModConfigurationDirectory() + "/" + MODID);
        configDir.mkdirs();
        ConfigHandler.init(new File(configDir.getPath(), MODID + ".cfg"));
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.registerTileEntities();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }

    public static final Logger LOGGER = LogManager.getLogger(EnderTotem.MODID);
}
