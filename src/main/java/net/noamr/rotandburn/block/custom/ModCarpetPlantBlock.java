package net.noamr.rotandburn.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.*;
import org.jetbrains.annotations.Nullable;

public class ModCarpetPlantBlock extends PlantBlock implements Fertilizable {
    public ModCarpetPlantBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends PlantBlock> getCodec() {
        return null;
    }

    protected static final VoxelShape SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 3.0, 16.0);

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Vec3d vec3d = state.getModelOffset(world, pos);
        return SHAPE.offset(vec3d.x, vec3d.y, vec3d.z);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(BlockTags.DIRT) || floor.isIn(BlockTags.BASE_STONE_OVERWORLD) || floor.isOf(Blocks.MOSS_BLOCK);
    }

    @Override
    public BlockState getAppearance(BlockState state, BlockRenderView renderView, BlockPos pos, Direction side, @Nullable BlockState sourceState, @Nullable BlockPos sourcePos) {
        return super.getAppearance(state, renderView, pos, side, sourceState, sourcePos);
    }

    @Override
    public boolean isEnabled(FeatureSet enabledFeatures) {
        return super.isEnabled(enabledFeatures);
    }

    @Override
    protected BlockState getStateForNeighborUpdate(
            BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos
    ) {
        return !state.canPlaceAt(world, pos)
                ? Blocks.AIR.getDefaultState()
                : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return type == NavigationType.AIR && !this.collidable || super.canPathfindThrough(state, type);
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
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        int flowersToGrow = random.nextInt(3) + 1; // Randomly determine how many flowers to grow (1 to 3)

        for (int i = 0; i < flowersToGrow; i++) {
            BlockPos newPos = pos.add(random.nextInt(3) - 1, 0, random.nextInt(3) - 1);

            BlockState newState = world.getBlockState(newPos);
            if (newState.isAir()) {
                if (canPlantOnTop(world.getBlockState(newPos.down()), world, newPos.down())) {
                    world.setBlockState(newPos, this.getDefaultState());
                }
            }
        }
    }
}
