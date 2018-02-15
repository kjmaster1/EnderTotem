package com.kjmaster.endertotem.init;

import com.kjmaster.endertotem.EnderTotem;
import com.kjmaster.endertotem.blocks.EnderTotemBlock;
import com.kjmaster.endertotem.blocks.tile.TileEnderTotem;
import jline.internal.Preconditions;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by pbill_000 on 02/09/2017.
 */
public class ModBlocks {
    public static final Block enderTotemBlock = new EnderTotemBlock(
            "ender_totem",
            Material.ROCK,
            CreativeTabs.MISC,
            50F,
            6000,
            true,
            TileEnderTotem.class);

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
        public static final Set<ItemBlock> ITEM_BLOCKS = new HashSet<>();

        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event) {
            final IForgeRegistry<Block> registry = event.getRegistry();
            final Block[] blocks = {
                    enderTotemBlock,

            };
            registry.registerAll(blocks);
            for (final Block block : blocks) {
            }

        }

        @SubscribeEvent
        public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
            final ItemBlock[] items = {
                    new ItemBlock(enderTotemBlock),

            };

            final IForgeRegistry<Item> registry = event.getRegistry();

            for (final ItemBlock item : items) {
                final Block block = item.getBlock();
                final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName());
                registry.register(item.setRegistryName(registryName));
                ITEM_BLOCKS.add(item);
            }
        }
    }
    @SideOnly(Side.CLIENT)
    public static void registerModels() {
        final Block[] blocks = {
                enderTotemBlock,

        };
        for(final Block block: blocks) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation( EnderTotem.MODID + ":" + block.getUnlocalizedName().substring(5), "inventory"));;
        }
        final ItemBlock[] items = {
                new ItemBlock(enderTotemBlock),

        };
        for(final ItemBlock item : items) {
            final Block block = item.getBlock();
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(EnderTotem.MODID + ":" + block.getUnlocalizedName().substring(5), "inventory"));
        }
    }
}
