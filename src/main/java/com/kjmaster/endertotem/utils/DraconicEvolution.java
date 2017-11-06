package com.kjmaster.endertotem.utils;

import codechicken.lib.vec.Vector3;
import com.brandon3055.draconicevolution.entity.EntityChaosGuardian;
import com.kjmaster.endertotem.blocks.tile.TileEnderTotem;
import net.minecraft.entity.Entity;;

public class DraconicEvolution {

    public static void doChaosDragon(Entity entity, double x1, double y1, double z1) {
        if (entity instanceof EntityChaosGuardian) {
            double x2 = entity.posX;
            double y2 = entity.posY;
            double z2 = entity.posZ;
            float distanceSqrd = (float) ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) + (z1 - z2) * (z1 - z2));
            EntityChaosGuardian dragon = (EntityChaosGuardian) entity;
            if(dragon.getHealth() <= 1) {

            } else if (distanceSqrd > 1)
                TileEnderTotem.setEntityMotionFromVector(entity, new Vector3(x1, y1, z1), 1 * 0.25F);
        }
    }
}
