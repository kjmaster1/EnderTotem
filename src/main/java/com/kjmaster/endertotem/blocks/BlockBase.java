package com.kjmaster.endertotem.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Created by pbill_000 on 02/09/2017.
 */
public class BlockBase extends Block {
    public BlockBase(String name, Material mat, CreativeTabs tab,
                     float hardness, float resistance, String tool, int harvest) {
        this(name, mat, tab, hardness, resistance);
        setHarvestLevel(tool, harvest);
    }

    public BlockBase(String name, Material mat, CreativeTabs tab, float hardness, float resistance, float light) {
        this(name, mat, tab, hardness, resistance);
        setLightLevel(light);
    }

    public BlockBase(String name, Material mat, CreativeTabs tab, float hardness, float resistance) {
        super(mat);
        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(hardness);
        setResistance(resistance);
        setCreativeTab(tab);
    }
}