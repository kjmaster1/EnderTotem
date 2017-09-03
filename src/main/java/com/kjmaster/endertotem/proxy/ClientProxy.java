package com.kjmaster.endertotem.proxy;


import com.kjmaster.endertotem.blocks.tile.EnderTotemTESR;
import com.kjmaster.endertotem.blocks.tile.TileEnderTotem;
import com.kjmaster.endertotem.init.ModBlocks;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by pbill_000 on 03/09/2017.
 */
@Mod.EventBusSubscriber
public class ClientProxy extends CommonProxy {

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        ModBlocks.registerModels();
        ClientRegistry.bindTileEntitySpecialRenderer(TileEnderTotem.class, new EnderTotemTESR());
    }
    @Override
    public void preInit(FMLPreInitializationEvent event) {}

    @Override
    public void init(FMLInitializationEvent event) {}

    @Override
    public void postInit(FMLPostInitializationEvent event) {}

    @Override
    public void serverStopping(FMLServerStoppingEvent event) {}

    @Override
    public void serverStarting(FMLServerStartingEvent event) {}


}
