package net.noamr.rotandburn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.noamr.rotandburn.block.ModBlocks;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool burntWoodPlanksPool = blockStateModelGenerator.registerCubeAllModelTexturePool((ModBlocks.BURNT_WOOD_PLANKS));

        burntWoodPlanksPool.stairs(ModBlocks.BURNT_WOOD_STAIRS);
        burntWoodPlanksPool.slab(ModBlocks.BURNT_WOOD_SLAB);
        burntWoodPlanksPool.fence(ModBlocks.BURNT_WOOD_FENCE);
        burntWoodPlanksPool.fenceGate(ModBlocks.BURNT_WOOD_FENCE_GATE);
        burntWoodPlanksPool.button(ModBlocks.BURNT_WOOD_BUTTON);
        burntWoodPlanksPool.pressurePlate(ModBlocks.BURNT_WOOD_PRESSURE_PLATE);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
