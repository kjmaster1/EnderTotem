package com.kjmaster.endertotem.blocks.tile;

import codechicken.lib.vec.Vector3;
import com.kjmaster.endertotem.EnderTotem;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.dragon.phase.PhaseDying;
import net.minecraft.entity.boss.dragon.phase.PhaseList;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.end.DragonFightManager;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by pbill_000 on 02/09/2017.
 */
public class TileEnderTotem extends TileEntity implements ITickable {

    private ItemStack stack = ItemStack.EMPTY;

    public ItemStack getStack() {
        return stack;
    }

    public void setStack(ItemStack stack) {
        this.stack = stack;
        markDirty();
        if (world != null) {
            IBlockState state = world.getBlockState(getPos());
            world.notifyBlockUpdate(getPos(), state, state, 3);
        }
    }


    @Override
    public NBTTagCompound getUpdateTag() {
        return writeToNBT(new NBTTagCompound());
    }

    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        this.writeToNBT(nbtTagCompound);
        return new SPacketUpdateTileEntity(getPos(), 1, nbtTagCompound);
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
        this.readFromNBT(pkt.getNbtCompound());
    }

    @Override
    public void update() {
        TileEnderTotem te = (TileEnderTotem) world.getTileEntity(pos);
        ItemStack stack = te.stack;
        Item item = stack.getItem();
        if (item.equals(Item.getItemFromBlock(Blocks.DRAGON_EGG))) {
            double x1 = pos.getX();
            double y1 = pos.getY() + 8;
            double z1 = pos.getZ();
            double range = 100;
            AxisAlignedBB boundingBox = new AxisAlignedBB(x1 - range, pos.getY(), z1 - range, x1 + range, y1 + range, z1 + range);
            List<Entity> entities = world.getEntitiesWithinAABB(Entity.class, boundingBox);

            for (Entity entity : entities) {
                if (entity instanceof EntityDragon) {
                    double x2 = entity.posX;
                    double y2 = entity.posY;
                    double z2 = entity.posZ;
                    float distanceSqrd = (float) ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) + (z1 - z2) * (z1 - z2));
                    EntityDragon dragon = (EntityDragon) entity;
                    if(dragon.getHealth() <= 1) {
                        EnderTotem.LOGGER.info("It died Jimmy");
                    } else if (distanceSqrd > 1)
                        setEntityMotionFromVector(entity, new Vector3(x1, y1, z1), 1 * 0.25F);
                }
            }
        }
    }
    //Credit for the following #setEntityMotionFromVector goes to Vazkii and nekosune
    private void setEntityMotionFromVector(Entity entity, Vector3 originalVec, float modifier) {
        Vector3 entityVector = Vector3.fromEntityCenter(entity);
        Vector3 finalVector = originalVec.copy().subtract(entityVector);

        if(finalVector.mag() > 1)
            finalVector.normalize();

        entity.motionX = finalVector.x * modifier;
        entity.motionY = finalVector.y * modifier;
        entity.motionZ = finalVector.z * modifier;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        if (!stack.isEmpty()) {
            NBTTagCompound tagCompound = new NBTTagCompound();
            stack.writeToNBT(tagCompound);
            compound.setTag("item", tagCompound);
        }
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        if (compound.hasKey("item")) {
            stack = new ItemStack(compound.getCompoundTag("item"));
        } else {
            stack = ItemStack.EMPTY;
        }
    }

}
