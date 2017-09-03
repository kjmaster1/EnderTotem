package com.kjmaster.endertotem.blocks.tile;

import com.kjmaster.endertotem.blocks.EnderTotemBlock;
import com.kjmaster.endertotem.init.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

/**
 * Created by pbill_000 on 03/09/2017.
 */

//Credit goes to McJty and his tutorial https://wiki.mcjty.eu/modding/index.php/Render_Block_TESR_/_OBJ-1.9
public class EnderTotemTESR extends TileEntitySpecialRenderer<TileEnderTotem> {

    @Override
    public void render(TileEnderTotem te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        GlStateManager.pushAttrib();
        GlStateManager.pushMatrix();

        // Translate to the location of our tile entity
        GlStateManager.translate(x, y, z);
        GlStateManager.disableRescaleNormal();

        // Render our item
        renderItem(te);

        GlStateManager.popMatrix();
        GlStateManager.popAttrib();
    }


    private void renderItem(TileEnderTotem te) {
        ItemStack stack = te.getStack();
        if (!stack.isEmpty()) {
            RenderHelper.enableStandardItemLighting();
            GlStateManager.enableLighting();
            GlStateManager.pushMatrix();
            // Translate to the center of the block and .9 points higher
            GlStateManager.translate(.5, 1.2, .5);
            GlStateManager.scale(.4f, .4f, .4f);

            Minecraft.getMinecraft().getRenderItem().renderItem(stack, ItemCameraTransforms.TransformType.NONE);

            GlStateManager.popMatrix();
        }
    }

}
