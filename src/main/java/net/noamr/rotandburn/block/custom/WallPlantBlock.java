package net.noamr.rotandburn.block.custom;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;
import java.util.Map;

public class WallPlantBlock extends Block {
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;

    private static final Map<Direction, VoxelShape> BOUNDING_SHAPES = Maps.newEnumMap(
            ImmutableMap.of(
                    Direction.NORTH,
                    Block.createCuboidShape(0.0, 0.0, 0.0, 3.0, 16.0, 16.0),
                    Direction.SOUTH,
                    Block.createCuboidShape(13.0, 0.0, 0.0, 16.0, 16.0, 16.0),
                    Direction.WEST,
                    Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 3.0),
                    Direction.EAST,
                    Block.createCuboidShape(0.0, 0.0, 13.0, 16.0, 16.0, 16.0)
            )
    );

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return getBoundingShape(state);
    }

    public static VoxelShape getBoundingShape(BlockState state) {
        return BOUNDING_SHAPES.get(state.get(FACING));
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

        return world.getBlockState(pos.offset(direction)).isSolid();
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState blockState = this.getDefaultState();
        WorldView worldView = ctx.getWorld();
        BlockPos blockPos = ctx.getBlockPos();
        Direction[] directions = ctx.getPlacementDirections();

        for (Direction direction : directions) {
            if (direction.getAxis().isHorizontal()) {
                Direction direction2 = direction.getOpposite();
                blockState = blockState.with(FACING, direction2);
                if (blockState.canPlaceAt(worldView, blockPos)) {
                    return blockState;
                }
            }
        }
        return null;
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
        super.neighborUpdate(state, world, pos, block, fromPos, notify);
        Direction facing = state.get(FACING).getOpposite();

        if (!world.getBlockState(pos.offset(facing)).isSolid()) {
            world.breakBlock(pos, true);
        }
    }

    public WallPlantBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

}

