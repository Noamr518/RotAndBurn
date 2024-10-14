package net.noamr.rotandburn.item.custom;


import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;

public class GrassSeedsItem extends Item {
    private static final Map<Block, Block> GRASS_SEEDS_MAP =
            Map.of(
                    Blocks.DIRT, Blocks.GRASS_BLOCK,
                    Blocks.COARSE_DIRT, Blocks.GRASS_BLOCK,
                    Blocks.FARMLAND, Blocks.GRASS_BLOCK,
                    Blocks.ROOTED_DIRT, Blocks.GRASS_BLOCK,
                    Blocks.DIRT_PATH, Blocks.GRASS_BLOCK
            );

    public GrassSeedsItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if (GRASS_SEEDS_MAP.containsKey(clickedBlock)) {
            if (!world.isClient() && world.getBlockState(context.getBlockPos().up()).isAir()) {
                world.setBlockState(context.getBlockPos(), GRASS_SEEDS_MAP.get(clickedBlock).getDefaultState());
                world.playSound(null, context.getBlockPos(), SoundEvents.ITEM_CROP_PLANT, SoundCategory.BLOCKS);
                context.getPlayer().getStackInHand(context.getHand()).decrement(1);
            }
            return ActionResult.CONSUME;
        }

        return ActionResult.PASS;
    }
}
