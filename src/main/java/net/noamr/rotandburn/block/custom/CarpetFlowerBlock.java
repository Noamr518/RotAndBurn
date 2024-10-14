package net.noamr.rotandburn.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class CarpetFlowerBlock extends FlowerBlock implements Fertilizable {
    public CarpetFlowerBlock(RegistryEntry<StatusEffect> stewEffect, float effectLengthInSeconds, Settings settings) {
        super(stewEffect, effectLengthInSeconds, settings);
    }
    protected static final VoxelShape SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 2.5, 15.0);

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Vec3d vec3d = state.getModelOffset(world, pos);
        return SHAPE.offset(vec3d.x, vec3d.y, vec3d.z);
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
            BlockPos newPos = pos.add(random.nextInt(5) - 2, 0, random.nextInt(5) - 2);

            BlockState newState = world.getBlockState(newPos);
            if (newState.isAir() || newState.isOf(Blocks.SHORT_GRASS) || newState.isOf(Blocks.TALL_GRASS)) {
                if (canPlantOnTop(world.getBlockState(newPos.down()), world, newPos.down())) {
                    world.setBlockState(newPos, this.getDefaultState());
                }
            }
        }
    }

}
