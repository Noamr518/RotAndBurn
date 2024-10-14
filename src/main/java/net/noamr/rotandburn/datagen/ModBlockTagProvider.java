package net.noamr.rotandburn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
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

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.SHALE)
                .add(ModBlocks.SHALE_FOSSIL)
                .add(ModBlocks.SALT_BLOCK);

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.YELLOW_EARTH)
                .add(ModBlocks.ASH_BLOCK);

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
    }
}
