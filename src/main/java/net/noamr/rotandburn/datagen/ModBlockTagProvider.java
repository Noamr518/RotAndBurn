package net.noamr.rotandburn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.noamr.rotandburn.block.ModBlocks;
import net.noamr.rotandburn.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Blocks.CARPET_FLOWERS)
                .add(ModBlocks.WOOD_ANEMONE);

        getOrCreateTagBuilder(ModTags.Blocks.APPLE_LOGS)
                .add(ModBlocks.APPLE_LOG)
                .add(ModBlocks.APPLE_WOOD)
                .add(ModBlocks.STRIPPED_APPLE_LOG)
                .add(ModBlocks.STRIPPED_APPLE_WOOD);

        getOrCreateTagBuilder(ModTags.Blocks.BURNT_LOGS)
                .add(ModBlocks.BURNT_LOG)
                .add(ModBlocks.BURNT_WOOD)
                .add(ModBlocks.STRIPPED_BURNT_LOG)
                .add(ModBlocks.STRIPPED_BURNT_WOOD);

        getOrCreateTagBuilder(ModTags.Blocks.BURNT_BLOCKS)
                .addTag(ModTags.Blocks.BURNT_LOGS)
                .add(ModBlocks.BURNT_LEAVES);

        getOrCreateTagBuilder(BlockTags.DOORS)
                .add(ModBlocks.APPLE_DOOR);

        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.APPLE_DOOR);

        getOrCreateTagBuilder(BlockTags.TRAPDOORS)
                .add(ModBlocks.APPLE_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.APPLE_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.SHALE)
                .add(ModBlocks.SHALE_FOSSIL)
                .add(ModBlocks.SALT_BLOCK);

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.YELLOW_EARTH)
                .add(ModBlocks.ASH_LAYER)
                .add(ModBlocks.ASH_BLOCK);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.BURNT_WOOD_BUTTON)
                .add(ModBlocks.BURNT_WOOD_PLANKS)
                .add(ModBlocks.BURNT_WOOD_PRESSURE_PLATE)
                .add(ModBlocks.BURNT_WOOD_FENCE)
                .add(ModBlocks.BURNT_WOOD_FENCE_GATE)
                .add(ModBlocks.BURNT_WOOD_SLAB)
                .add(ModBlocks.BURNT_WOOD_STAIRS)
                .add(ModBlocks.BURNT_LOG)
                .add(ModBlocks.BURNT_WOOD)
                .add(ModBlocks.STRIPPED_BURNT_LOG)
                .add(ModBlocks.STRIPPED_BURNT_WOOD)
                .add(ModBlocks.APPLE_LOG)
                .add(ModBlocks.APPLE_WOOD)
                .add(ModBlocks.STRIPPED_APPLE_LOG)
                .add(ModBlocks.STRIPPED_APPLE_WOOD)
                .add(ModBlocks.APPLE_SLAB)
                .add(ModBlocks.APPLE_STAIRS)
                .add(ModBlocks.APPLE_FENCE)
                .add(ModBlocks.APPLE_FENCE_GATE)
                .add(ModBlocks.APPLE_BUTTON)
                .add(ModBlocks.APPLE_PRESSURE_PLATE)
                .add(ModBlocks.SHRUB);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.APPLE_LOG)
                .add(ModBlocks.APPLE_WOOD)
                .add(ModBlocks.STRIPPED_APPLE_LOG)
                .add(ModBlocks.STRIPPED_APPLE_WOOD);

        getOrCreateTagBuilder(BlockTags.LEAVES)
                .add(ModBlocks.APPLE_LEAVES)
                .add(ModBlocks.BURNT_LEAVES);

        getOrCreateTagBuilder(BlockTags.REPLACEABLE)
                .add(ModBlocks.TRIM_GRASS)
                .add(ModBlocks.BROADLEAF_PLANTAIN)
                .add(ModBlocks.GRASS_CARPET)
                .add(ModBlocks.DUNE_GRASS)
                .add(ModBlocks.CLOVER)
                .add(ModBlocks.BUSHY_FERN)
                .add(ModBlocks.LARGE_BUSH_GRASS)
                .add(ModBlocks.TALL_PLAINS_GRASS);

        getOrCreateTagBuilder(BlockTags.REPLACEABLE_BY_TREES)
                .add(ModBlocks.TRIM_GRASS)
                .add(ModBlocks.BROADLEAF_PLANTAIN)
                .add(ModBlocks.GRASS_CARPET)
                .add(ModBlocks.DUNE_GRASS)
                .add(ModBlocks.CLOVER)
                .add(ModBlocks.BUSHY_FERN)
                .add(ModBlocks.LARGE_BUSH_GRASS)
                .add(ModBlocks.TALL_PLAINS_GRASS);

        getOrCreateTagBuilder(BlockTags.SWORD_EFFICIENT)
                .add(ModBlocks.IVY)
                .add(ModBlocks.POISON_IVY)
                .add(ModBlocks.WITHERED_IVY)
                .add(ModBlocks.TRIM_GRASS)
                .add(ModBlocks.BROADLEAF_PLANTAIN)
                .add(ModBlocks.GRASS_CARPET)
                .add(ModBlocks.SHRUB)
                .add(ModBlocks.DUNE_GRASS)
                .add(ModBlocks.CLOVER)
                .add(ModBlocks.BUSHY_FERN)
                .add(ModBlocks.LARGE_BUSH_GRASS)
                .add(ModBlocks.WOOD_ANEMONE)
                .add(ModBlocks.CARDINAL_FLOWER)
                .add(ModBlocks.GOLDENROD)
                .add(ModBlocks.BUTTERFLY_MILKWEED)
                .add(ModBlocks.THISTLE)
                .add(ModBlocks.INDIAN_PAINTBRUSH)
                .add(ModBlocks.MARIGOLD)
                .add(ModBlocks.APPLE_LEAVES)
                .add(ModBlocks.BURNT_LEAVES);


        getOrCreateTagBuilder(BlockTags.PIGLIN_REPELLENTS)
                .add(ModBlocks.WITHERED_IVY);

        getOrCreateTagBuilder(BlockTags.BASE_STONE_OVERWORLD)
                .add(ModBlocks.SHALE)
                .add(ModBlocks.SHALE_FOSSIL);

        getOrCreateTagBuilder(BlockTags.DIRT)
                .add(ModBlocks.YELLOW_EARTH);

        getOrCreateTagBuilder(BlockTags.FALL_DAMAGE_RESETTING)
                .add(ModBlocks.THISTLE)
                .add(ModBlocks.BLUEBERRY_BUSH);

        getOrCreateTagBuilder(BlockTags.FLOWERS)
                .addTag(ModTags.Blocks.CARPET_FLOWERS);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.SHALE_FOSSIL);

        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS)
                .add(ModBlocks.THISTLE)
                .add(ModBlocks.INDIAN_PAINTBRUSH);

        getOrCreateTagBuilder(BlockTags.TALL_FLOWERS)
                .add(ModBlocks.CARDINAL_FLOWER)
                .add(ModBlocks.GOLDENROD)
                .add(ModBlocks.BUTTERFLY_MILKWEED);

        getOrCreateTagBuilder(BlockTags.COMPLETES_FIND_TREE_TUTORIAL)
                .add(ModBlocks.APPLE_LOG)
                .add(ModBlocks.APPLE_LEAVES);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.BURNT_WOOD_FENCE)
                .add(ModBlocks.APPLE_FENCE);

        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.BURNT_WOOD_FENCE)
                .add(ModBlocks.APPLE_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.BURNT_WOOD_FENCE_GATE)
                .add(ModBlocks.APPLE_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.APPLE_PLANKS)
                .add(ModBlocks.BURNT_WOOD_PLANKS);

        getOrCreateTagBuilder(BlockTags.BUTTONS)
                .add(ModBlocks.BURNT_WOOD_BUTTON)
                .add(ModBlocks.APPLE_BUTTON);

        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.BURNT_WOOD_BUTTON)
                .add(ModBlocks.APPLE_BUTTON);

        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(ModBlocks.BURNT_WOOD_SLAB)
                .add(ModBlocks.APPLE_SLAB);

        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.BURNT_WOOD_SLAB)
                .add(ModBlocks.APPLE_SLAB);

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(ModBlocks.BURNT_WOOD_STAIRS)
                .add(ModBlocks.APPLE_STAIRS);

        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.BURNT_WOOD_STAIRS)
                .add(ModBlocks.APPLE_STAIRS);

        getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES)
                .add(ModBlocks.BURNT_WOOD_PRESSURE_PLATE)
                .add(ModBlocks.APPLE_PRESSURE_PLATE);

        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.BURNT_WOOD_PRESSURE_PLATE)
                .add(ModBlocks.APPLE_PRESSURE_PLATE);
    }
}
