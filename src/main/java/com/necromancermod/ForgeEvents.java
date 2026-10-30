package com.necromancermod;

import com.necromancermod.entity.NecromancerEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NecromancerMod.MODID)
public class ForgeEvents {

    /** Sipy minionu Necromancera letí skrz nej (neublizi mu a neodrazi se). */
    @SubscribeEvent
    public static void onProjectileImpact(ProjectileImpactEvent event) {
        if (event.getRayTraceResult() instanceof EntityHitResult hit && hit.getEntity() instanceof NecromancerEntity) {
            Entity owner = event.getProjectile().getOwner();
            if (owner != null && owner.getTags().contains(NecromancerEntity.MINION_TAG)) {
                event.setCanceled(true);
            }
        }
    }
}
