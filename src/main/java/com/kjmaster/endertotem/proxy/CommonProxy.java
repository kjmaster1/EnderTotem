package com.kjmaster.endertotem.proxy;

import com.kjmaster.endertotem.EnderTotem;
import com.kjmaster.endertotem.blocks.tile.TileEnderTotem;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by pbill_000 on 03/09/2017.
 */
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {}
    public void init(FMLInitializationEvent event) {}
    public void postInit(FMLPostInitializationEvent event) {}
    public void serverStopping(FMLServerStoppingEvent event) {}
    public void serverStarting(FMLServerStartingEvent event) {}

    public void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEnderTotem.class, EnderTotem.MODID + ":ender_totem");
    }

    @SidedProxy(clientSide = EnderTotem.CLIENT_PROXY, serverSide = EnderTotem.COMMON_PROXY)
    public static CommonProxy proxy;
}
