package net.noamr.rotandburn.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WitherIvyBlock extends IvyBlock{

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity && entity.getType() != EntityType.GOAT && entity.getType() != EntityType.BEE) {
            if (!world.isClient && (entity.lastRenderX != entity.getX() || entity.lastRenderZ != entity.getZ())) {
                double d = Math.abs(entity.getX() - entity.lastRenderX);
                double f = Math.abs(entity.getY() - entity.lastRenderY);
                double e = Math.abs(entity.getZ() - entity.lastRenderZ);
                if (d >= 0.001F || e >= 0.001F || f >= 0.001F) {
                    entity.damage(world.getDamageSources().wither(), 1F);
                    ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 75, 1));
                    ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 50, 1));
                    ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 180, 2));
                }
            }
        }
    }

    public WitherIvyBlock(Settings settings) {
        super(settings);
    }
}
