package com.kjmaster.endertotem;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.kjmaster.endertotem.proxy.CommonProxy.proxy;

@Mod(modid = EnderTotem.MODID, version = EnderTotem.VERSION)
public class EnderTotem
{
    public static final String MODID = "endertotem";
    public static final String VERSION = "1.0";
    public static final String CLIENT_PROXY = "com.kjmaster.endertotem.proxy.ClientProxy";
    public static final String COMMON_PROXY = "com.kjmaster.endertotem.proxy.CommonProxy";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

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
