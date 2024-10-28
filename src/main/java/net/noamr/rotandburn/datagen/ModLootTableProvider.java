package net.noamr.rotandburn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;
import net.noamr.rotandburn.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.YELLOW_EARTH);
        addDrop(ModBlocks.SHALE);
        addDrop(ModBlocks.THISTLE);
        addDrop(ModBlocks.INDIAN_PAINTBRUSH);
        addDrop(ModBlocks.SHRUB);

        addDrop(ModBlocks.BURNT_WOOD_PLANKS);
        addDrop(ModBlocks.BURNT_WOOD_STAIRS);
        addDrop(ModBlocks.BURNT_WOOD_SLAB, slabDrops(ModBlocks.BURNT_WOOD_SLAB));
        addDrop(ModBlocks.BURNT_WOOD_FENCE);
        addDrop(ModBlocks.BURNT_WOOD_FENCE_GATE);
        addDrop(ModBlocks.BURNT_WOOD_BUTTON);
        addDrop(ModBlocks.BURNT_WOOD_PRESSURE_PLATE);


    }
}
