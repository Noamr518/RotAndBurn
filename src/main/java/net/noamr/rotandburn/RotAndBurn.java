package net.noamr.rotandburn;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.noamr.rotandburn.block.ModBlocks;
import net.noamr.rotandburn.item.ModItemGroups;
import net.noamr.rotandburn.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RotAndBurn implements ModInitializer {
	public static final String MOD_ID = "rotandburn";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		FuelRegistry.INSTANCE.add(ModItems.FLAME_PASTE, 3850);

		StrippableBlockRegistry.register(ModBlocks.APPLE_LOG, ModBlocks.STRIPPED_APPLE_LOG);
		StrippableBlockRegistry.register(ModBlocks.APPLE_WOOD, ModBlocks.STRIPPED_APPLE_WOOD);
		StrippableBlockRegistry.register(ModBlocks.BURNT_LOG, ModBlocks.STRIPPED_BURNT_LOG);
		StrippableBlockRegistry.register(ModBlocks.BURNT_WOOD, ModBlocks.STRIPPED_BURNT_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.APPLE_LOG,5,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.APPLE_WOOD,5,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_APPLE_LOG,5,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_APPLE_WOOD,5,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.APPLE_PLANKS,5,20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.APPLE_SLAB,5,20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.APPLE_STAIRS,5,20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.APPLE_FENCE,5,20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.APPLE_FENCE_GATE,5,20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.APPLE_LEAVES,30,50);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BURNT_LOG,8,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BURNT_WOOD,8,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_BURNT_LOG,8,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_BURNT_WOOD,8,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BURNT_WOOD_PLANKS,8,25);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BURNT_WOOD_SLAB,8,25);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BURNT_WOOD_STAIRS,8,25);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BURNT_WOOD_FENCE,8,25);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BURNT_WOOD_FENCE_GATE,8,25);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BURNT_LEAVES,36,75);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.IVY,18,100);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.POISON_IVY,22,100);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.TRIM_GRASS,60,100);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BROADLEAF_PLANTAIN,60,100);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.GRASS_CARPET,60,100);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DUNE_GRASS,80,100);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.TALL_PLAINS_GRASS,80,100);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.LARGE_BUSH_GRASS,80,100);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BURNT_LEAVES,60,100);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SHRUB,30,65);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BUSHY_FERN,60,100);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CARDINAL_FLOWER,60,100);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.GOLDENROD,60,100);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BUTTERFLY_MILKWEED,60,100);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.WOOD_ANEMONE,60,100);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.INDIAN_PAINTBRUSH,60,100);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.THISTLE,60,100);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MARIGOLD,60,100);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CLOVER,100,100);





	}
}