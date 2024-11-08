package net.noamr.rotandburn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.noamr.rotandburn.block.ModBlocks;
import net.noamr.rotandburn.item.ModItems;

import javax.annotation.processing.Generated;

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

        BlockStateModelGenerator.BlockTexturePool applePlanksPool = blockStateModelGenerator.registerCubeAllModelTexturePool((ModBlocks.APPLE_PLANKS));
        applePlanksPool.stairs(ModBlocks.APPLE_STAIRS);
        applePlanksPool.slab(ModBlocks.APPLE_SLAB);
        applePlanksPool.fence(ModBlocks.APPLE_FENCE);
        applePlanksPool.fenceGate(ModBlocks.APPLE_FENCE_GATE);
        applePlanksPool.button(ModBlocks.APPLE_BUTTON);
        applePlanksPool.pressurePlate(ModBlocks.APPLE_PRESSURE_PLATE);

        blockStateModelGenerator.registerDoor(ModBlocks.APPLE_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.APPLE_TRAPDOOR);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ModItems.RUIN_TRIM, Models.GENERATED);

    }
}
