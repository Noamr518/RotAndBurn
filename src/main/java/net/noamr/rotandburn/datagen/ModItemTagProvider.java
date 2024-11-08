package net.noamr.rotandburn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.noamr.rotandburn.block.ModBlocks;
import net.noamr.rotandburn.item.ModItems;
import net.noamr.rotandburn.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.BURNT_WOOD_PLANKS.asItem())
                .add(ModBlocks.APPLE_PLANKS.asItem());
        getOrCreateTagBuilder(ItemTags.DIRT)
                .add(ModBlocks.YELLOW_EARTH.asItem());
        getOrCreateTagBuilder(ItemTags.FOX_FOOD)
                .add(ModItems.BLUEBERRY);
        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.APPLE_LOG.asItem())
                .add(ModBlocks.APPLE_WOOD.asItem())
                .add(ModBlocks.STRIPPED_APPLE_LOG.asItem())
                .add(ModBlocks.STRIPPED_APPLE_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS)
                .add(ModItems.GARNET);
        getOrCreateTagBuilder(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.RUIN_TRIM);
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.RUIN_TRIM);

        getOrCreateTagBuilder(ItemTags.PARROT_FOOD)
                .add(ModItems.BLUEBERRY);

        getOrCreateTagBuilder(ModTags.Items.APPLE_LOGS)
                .add(ModBlocks.APPLE_LOG.asItem())
                .add(ModBlocks.APPLE_WOOD.asItem())
                .add(ModBlocks.STRIPPED_APPLE_LOG.asItem())
                .add(ModBlocks.STRIPPED_APPLE_WOOD.asItem());

        getOrCreateTagBuilder(ModTags.Items.BURNT_LOGS)
                .add(ModBlocks.BURNT_LOG.asItem())
                .add(ModBlocks.BURNT_WOOD.asItem())
                .add(ModBlocks.STRIPPED_BURNT_LOG.asItem())
                .add(ModBlocks.STRIPPED_BURNT_WOOD.asItem());

        getOrCreateTagBuilder(ModTags.Items.BURNT_BLOCKS)
                .addTag(ModTags.Items.BURNT_LOGS)
                .add(ModBlocks.BURNT_LEAVES.asItem());
    }
}
