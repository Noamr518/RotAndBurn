package net.noamr.rotandburn.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class ModSandPlant extends ModMediumPlantBlock{

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(BlockTags.DIRT) || floor.isOf(Blocks.SANDSTONE) || floor.isIn(BlockTags.SAND);
    }

    public ModSandPlant(Settings settings) {
        super(settings);
    }
}
