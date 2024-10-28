package net.noamr.rotandburn.block.custom;


import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;


import java.util.Map;


public class WallFlowerBlock extends DeadCoralWallFanBlock {
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;


    private static final Map<Direction, VoxelShape> FACING_TO_SHAPE = Maps.newEnumMap(
            ImmutableMap.of(
                    Direction.NORTH,
                    Block.createCuboidShape(0.0, 4.0, 5.0, 16.0, 12.0, 16.0),
                    Direction.SOUTH,
                    Block.createCuboidShape(0.0, 4.0, 0.0, 16.0, 12.0, 11.0),
                    Direction.WEST,
                    Block.createCuboidShape(5.0, 4.0, 0.0, 16.0, 12.0, 16.0),
                    Direction.EAST,
                    Block.createCuboidShape(0.0, 4.0, 0.0, 11.0, 12.0, 16.0)
            )
    );


    protected static boolean isInWater(BlockState state, BlockView world, BlockPos pos) {
        return false;
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return (VoxelShape) FACING_TO_SHAPE.get(state.get(FACING));
    }


    @Override
    protected BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }


    @Override
    protected BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }


    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Direction direction = state.get(FACING).getOpposite();
        BlockPos blockPosBelow = pos.offset(Direction.DOWN);
        BlockPos blockPosAbove = pos.offset(Direction.UP);


        return world.isAir(blockPosBelow) && world.isAir(blockPosAbove) &&
                world.getBlockState(pos.offset(direction)).isSolid();
    }


    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState blockState = this.getDefaultState();
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        WorldView worldView = ctx.getWorld();
        BlockPos blockPos = ctx.getBlockPos();
        Direction[] directions = ctx.getPlacementDirections();


        for (Direction direction : directions) {
            if (direction.getAxis().isHorizontal()) {
                Direction direction2 = direction.getOpposite();
                blockState = blockState.with(FACING, direction2);
                if (blockState.canPlaceAt(worldView, blockPos)) {
                    return blockState.with(WATERLOGGED, Boolean.valueOf(fluidState.getFluid() == Fluids.WATER));
                }
            }
        }


        return null;
    }


    public WallFlowerBlock(Settings settings) {
        super(settings);
    }
}

