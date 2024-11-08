package net.noamr.rotandburn.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import net.noamr.rotandburn.block.ModBlocks;

import java.util.Map;
import java.util.Random;

public class GrassSeedsItem extends Item {
    private static final Map<Block, Block> GRASS_SEEDS_MAP =
            Map.of(
                    Blocks.DIRT, Blocks.GRASS_BLOCK,
                    Blocks.COARSE_DIRT, Blocks.GRASS_BLOCK,
                    Blocks.FARMLAND, Blocks.GRASS_BLOCK,
                    Blocks.ROOTED_DIRT, Blocks.GRASS_BLOCK,
                    Blocks.DIRT_PATH, Blocks.GRASS_BLOCK
            );

    // Array of placeholder blocks (replace these with your actual blocks later)
    private static final Block[] PLACEHOLDER_PLANTS = {
            Blocks.SHORT_GRASS,
            Blocks.FERN,
            ModBlocks.TRIM_GRASS,
            ModBlocks.BROADLEAF_PLANTAIN,
            ModBlocks.GRASS_CARPET,
            ModBlocks.CLOVER
    };

    private final Random random = new Random();

    public GrassSeedsItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        // Check if clicked block is a grass block
        if (clickedBlock == Blocks.GRASS_BLOCK) {
            if (!world.isClient() && world.getBlockState(context.getBlockPos().up()).isAir()) {
                // Set the block state to a random placeholder plant
                Block randomPlant = PLACEHOLDER_PLANTS[random.nextInt(PLACEHOLDER_PLANTS.length)];
                world.setBlockState(context.getBlockPos().up(), randomPlant.getDefaultState());

                world.playSound(null, context.getBlockPos(), SoundEvents.ITEM_CROP_PLANT, SoundCategory.BLOCKS);
                context.getPlayer().getStackInHand(context.getHand()).decrement(1);
            }
            return ActionResult.CONSUME;
        }

        // Check if clicked block is in the GRASS_SEEDS_MAP
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
