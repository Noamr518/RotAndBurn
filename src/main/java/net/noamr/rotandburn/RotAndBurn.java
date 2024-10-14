package net.noamr.rotandburn;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
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
	}
}