package net.noamr.rotandburn.block.custom;


import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.block.*;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import java.util.Map;


public class WallFlowerBlock extends WallPlantBlock {
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;

    private static final Map<Direction, VoxelShape> FACING_TO_SHAPE = Maps.newEnumMap(
            ImmutableMap.of(
                    Direction.NORTH,
                    Block.createCuboidShape(0.0, 0.0, 13.0, 16.0, 16.0, 16.0),
                    Direction.SOUTH,
                    Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 3.0),
                    Direction.WEST,
                    Block.createCuboidShape(13.0, 0.0, 0.0, 16.0, 16.0, 16.0),
                    Direction.EAST,
                    Block.createCuboidShape(0.0, 0.0, 0.0, 3.0, 16.0, 16.0)
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
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Direction direction = state.get(FACING).getOpposite();
        BlockPos blockPosBelow = pos.offset(Direction.DOWN);


        return world.isAir(blockPosBelow) &&
                world.getBlockState(pos.offset(direction)).isSolid();
    }

    public WallFlowerBlock(Settings settings) {
        super(settings);
    }
}

