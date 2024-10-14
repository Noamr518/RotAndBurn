package net.noamr.rotandburn.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.PlantBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class ThistleBlock extends PlantBlock implements Fertilizable {
    public ThistleBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends PlantBlock> getCodec() {
        return null;
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity && entity.getType() != EntityType.FOX && entity.getType() != EntityType.BEE) {
            entity.slowMovement(state, new Vec3d(0.9F, 1.1F, 0.9F));
            if (!world.isClient && (entity.lastRenderX != entity.getX() || entity.lastRenderZ != entity.getZ())) {
                double d = Math.abs(entity.getX() - entity.lastRenderX);
                double e = Math.abs(entity.getZ() - entity.lastRenderZ);
                if (d >= 0.003F || e >= 0.003F) {
                    entity.damage(world.getDamageSources().sweetBerryBush(), 0.75F);
                }
            }
        }
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, net.minecraft.util.math.random.Random random, BlockPos pos, BlockState state) {
        int flowersToGrow = random.nextInt(3) + 1; // Randomly determine how many flowers to grow (1 to 3)

        for (int i = 0; i < flowersToGrow; i++) {
            BlockPos newPos = pos.add(random.nextInt(3) - 1, 0, random.nextInt(3) - 1);

            BlockState newState = world.getBlockState(newPos);
            if (newState.isAir() || newState.isOf(Blocks.SHORT_GRASS) || newState.isOf(Blocks.TALL_GRASS)) {
                if (canPlantOnTop(world.getBlockState(newPos.down()), world, newPos.down())) {
                    world.setBlockState(newPos, this.getDefaultState());
                }
            }
        }
    }
}
